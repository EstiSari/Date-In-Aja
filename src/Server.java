import java.io.BufferedReader;
import java.io.I;
import java.io.IOException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends javax.swing.JPanel {
    
    
   private ServerSocket serverSocket;
    private int port;
    private boolean running = false;

    public Server( int port )
    {
        this.port = port;
    }

    public void startServer() throws IOException
    {
        serverSocket = new ServerSocket( port );
        this.start();
    }

    public void stopServer()
    {
        running = false;
        this.interrupt();
    }

    @Override
    public void run() throws IOException
    {
        running = true;
        while( running )
        {
            System.out.println( "Listening for a connection" );
            // Call accept() to receive the next connection
            Socket socket = serverSocket.accept();
            // Pass the socket to the RequestHandler thread for processing
            RequestHandler requestHandler = new RequestHandler( socket );
            requestHandler.start();
        }
    }
    public static void main( String[] args )
    {
        if( args.length == 0 )
        {
            System.out.println( "Usage: SimpleSocketServer <port>" );
            System.exit( 0 );
        }
        int port = Integer.parseInt( args[ 0 ] );
        System.out.println( "Start server on port: " + port );

        SimpleSocketServer server = new SimpleSocketServer( port );
        server.startServer();

        // Automatically shutdown in 1 minute
        try
        {
            Thread.sleep( 60000 );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        server.stopServer();
    }

    private void start() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void interrupt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class RequestHandler extends Thread
{
    private Socket socket;
    RequestHandler( Socket socket )
    {
        this.socket = socket;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println( "Received a connection" );

            // Get input and output streams
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            PrintWriter out = new PrintWriter( socket.getOutputStream() );

            // Write out our header to the client
            out.println( "Echo Server 1.0" );
            out.flush();

            // Echo lines back to the client until the client closes the connection or we receive an empty line
            String line = in.readLine();
            while( line != null && line.length() > 0 )
            {
                out.println( "Echo: " + line );
                out.flush();
                line = in.readLine();
            }

            // Close our connection
            in.close();
            out.close();
            socket.close();

            System.out.println( "Connection closed" );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
   
    public Server() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        btnOnlineUser = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 255));
        setMaximumSize(new java.awt.Dimension(550, 355));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(579, 412));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DateInAja");

        btnStart.setBackground(new java.awt.Color(255, 255, 255));
        btnStart.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnStart.setForeground(new java.awt.Color(102, 102, 255));
        btnStart.setText("START");
        btnStart.setMaximumSize(new java.awt.Dimension(145, 31));
        btnStart.setMinimumSize(new java.awt.Dimension(145, 31));
        btnStart.setPreferredSize(new java.awt.Dimension(145, 31));

        btnEnd.setBackground(new java.awt.Color(255, 255, 255));
        btnEnd.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnEnd.setForeground(new java.awt.Color(102, 102, 255));
        btnEnd.setText("END");
        btnEnd.setMaximumSize(new java.awt.Dimension(145, 31));
        btnEnd.setMinimumSize(new java.awt.Dimension(145, 31));
        btnEnd.setPreferredSize(new java.awt.Dimension(145, 31));

        btnOnlineUser.setBackground(new java.awt.Color(255, 255, 255));
        btnOnlineUser.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnOnlineUser.setForeground(new java.awt.Color(102, 102, 255));
        btnOnlineUser.setText("Online Users");

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(102, 102, 255));
        btnClear.setText("Clear");
        btnClear.setMaximumSize(new java.awt.Dimension(145, 31));
        btnClear.setMinimumSize(new java.awt.Dimension(145, 31));
        btnClear.setPreferredSize(new java.awt.Dimension(145, 31));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOnlineUser))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOnlineUser))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnOnlineUser;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
