package com.laishishui.lhrpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Create by tachai on 2020-02-11 21:40
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Slf4j
public class HttpTransportServer implements TransportServer {
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler=handler;
        this.server=new Server(port);
        // servlet接受请求
        ServletContextHandler ctx=new ServletContextHandler();
        server.setHandler(ctx);
        // 研究一下
        ServletHolder holder= new ServletHolder(new RequestServlet());
        ctx.addServlet(holder,"/*");

    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class RequestServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");


           InputStream in = req.getInputStream();
            OutputStream out = resp.getOutputStream();

            if(handler!=null){
                handler.onRequest(in,out);
            }
        }
    }
}
