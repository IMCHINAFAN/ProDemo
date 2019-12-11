package cn.study.base.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName: MyFilter
 * @author: 10724
 * @date: Created in 2019/11/8
 * @Description:
 */
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我的filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
