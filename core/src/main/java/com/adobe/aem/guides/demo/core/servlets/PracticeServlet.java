/*
 * package com.adobe.aem.guides.demo.core.servlets;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.Servlet; import javax.servlet.ServletException;
 * 
 * import org.apache.sling.api.SlingHttpServletRequest; import
 * org.apache.sling.api.SlingHttpServletResponse; import
 * org.apache.sling.api.servlets.SlingAllMethodsServlet; import
 * org.osgi.service.component.annotations.Component; import
 * org.osgi.service.component.annotations.Reference;
 * 
 * import com.adobe.aem.guides.demo.servicesIMPL.SimpleService;
 * 
 * 
 * @Component(service = Servlet.class) public class PracticeServlet extends
 * SlingAllMethodsServlet{
 * 
 * 
 * @Reference SimpleService simpleService;
 * 
 * 
 * @Override protected void doGet(SlingHttpServletRequest request,
 * SlingHttpServletResponse response) throws ServletException, IOException {
 * 
 * 
 * request.getRequestPathInfo().getSelectors();
 * 
 * 
 * 
 * simpleService.methodm1(); // TODO Auto-generated method stub
 * super.doGet(request, response); }
 * 
 * }
 */