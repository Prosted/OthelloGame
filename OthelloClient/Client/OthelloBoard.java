package Client;

// JavaObjClientView.java ObjecStram 기반 Client
//실질적인 채팅 창
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class OthelloBoard extends JFrame {
    private JPanel contentPane;
    private JLabel lblUserName;
    private JTextPane textArea;
    private OthelloView view;

    public OthelloBoard(OthelloView view, int posX, int posY) {
        this.view = view;

        //Frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(posX, posY, 394, 630);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //ScrollPane
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 352, 471);
        contentPane.add(scrollPane);

        //TextArea
        textArea = new JTextPane();
        textArea.setEditable(true);
        textArea.setFont(new Font("굴림체", Font.PLAIN, 14));
        scrollPane.setViewportView(textArea);

        //유저 이름
        lblUserName = new JLabel(view.getUserName());
        lblUserName.setBorder(new LineBorder(new Color(0, 0, 0)));
        lblUserName.setBackground(Color.WHITE);
        lblUserName.setFont(new Font("굴림", Font.BOLD, 14));
        lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserName.setBounds(12, 490, 62, 40);
        contentPane.add(lblUserName);
        setVisible(true);

        //접속 종료 버튼
        JButton btnDisConnect = new JButton("Disconnect");
        btnDisConnect.setBounds(84, 490, 100, 40);
        contentPane.add(btnDisConnect);
        DisconnectAction disconnectAction = new DisconnectAction();
        btnDisConnect.addActionListener(disconnectAction);
    }

    class DisconnectAction implements ActionListener // 접속 종료 이벤트 발생
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.Discconect();
        }
    }

    // 화면에 출력
    public void AppendText(String msg) {
        // textArea.append(msg + "\n");
        msg = msg.trim(); // 앞뒤 blank와 \n을 제거한다.
        int len = textArea.getDocument().getLength();

        // 끝으로 이동
        textArea.setCaretPosition(len);
        textArea.replaceSelection(msg + "\n");
    }
}
