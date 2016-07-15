package br.com.guardaqui.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class Todos implements Filter {

	private static final Logger log = Logger.getLogger(Todos.class.getName());
	
	private FilterConfig filterConfig = null;
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		  long start = System.currentTimeMillis();
		    String address =  req.getRemoteAddr();
		    HttpServletRequest request = (HttpServletRequest) req;
		    HttpServletResponse response = (HttpServletResponse) res;
		    
		    response.addHeader("Access-Control-Allow-Origin", "*");
		    response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		    response.addHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");
		    
		    String file = request.getRequestURI();
		    
		    
		    chain.doFilter(req, res);
		    
		    log.log(Level.INFO,
		    		"[ACESSO=" +      
			        "User IP:" + address +
			        "; Method: " + request.getMethod() +
			        "; Resource: " + file + 
			        "; Milliseconds used: " + (System.currentTimeMillis() - start) + "]"
		    );
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
