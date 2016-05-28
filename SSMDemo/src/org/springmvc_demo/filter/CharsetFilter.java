package org.springmvc_demo.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharsetFilter implements Filter {

	private static String encode = "UTF-8";// 默认UTF-8编码
	
	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;  
        HttpServletResponse response = (HttpServletResponse) arg1;  
        
        /*
         * 设置request编码   , 该设置仅对POST有效。
         */
        request.setCharacterEncoding(encode);
        
        /*
         * 设置发送到客户端的响应的内容类型,可以包括字符编码说明。
         * 如果该方法在getWriter()方法被调用之前调用，那么响应的字符编码将仅从给出的内容类型中设置。
         * 该方法如果在getWriter()方法被调用之后或者在被提交之后调用，
         * 将不会设置响应的字符编码,在使用http协议的情况中，该方法设置 Content-type实体报头 。
         */
        response.setContentType("text/html;charset=" + encode);  
        
        /*
         *	如果服务器端使用response.setContentType设置了编码格式,
         *	那么应该使用 response.setCharacterEncoding指定的编码格式，这样就会把之前的设置屏蔽掉。 
         */
        response.setCharacterEncoding(encode);
        
        /*
         * 这段代码会将页面提交的信息编码由ISO8859-1转换为UTF-8
         */
        arg2.doFilter(new CharacterEncodingRequest(request), response);
	}

	
	/**
	 * 在初始化的时候激昂web.xml文件中设置好的编码去除，代替程序中默认的编码
	 */
	public void init(FilterConfig arg0) throws ServletException {
		
		String encoding = arg0.getInitParameter("encode");
		if (encoding != null) {
			encode = encoding;
		}
	}

	class CharacterEncodingRequest extends HttpServletRequestWrapper {
		
		private HttpServletRequest request = null;

		public CharacterEncodingRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
		}

		/**
		 * 对参数重新编码
		 */
		@Override
		public String getParameter(String name) {

			String value = super.getParameter(name);
			
			if (value == null)
				return null;
		
			String method = request.getMethod();
			
			if ("get".equalsIgnoreCase(method)) {
				try {
					value = new String(value.getBytes("ISO8859-1"),  request.getCharacterEncoding());
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			return value;
		}
	}
}
