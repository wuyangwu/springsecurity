package com.example.wy.test;

import sun.plugin2.ipc.windows.WindowsEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

/**
 * @author wuyang
 * @version 1.0
 * @date 2019/9/21 23:31
 */
public class java_3 extends JFrame {
    public java_3(){
        super( "打印无符号整数位" );
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add( new JLabel( "请输入整数: " ) );
        final JTextField output = new JTextField( 33 );
        JTextField input = new JTextField( 10 );
        input.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int val = Integer.parseInt(
                                e.getActionCommand() );
                        //*********Found********
                        output.setText( getBits( val ) );
                    }
                }
        );
        c.add( input );
        c.add( new JLabel( "该数的二进制位表示是" ) );
        output.setEditable( false );
        //*********Found********
        c.add(output);
        setSize( 720, 70 );
        setVisible(true);
    }

    private String getBits( int value ){
        int displayMask = 1 << 31;
        StringBuffer buf = new StringBuffer( 35 );
        System.out.println("dsa"+displayMask);
        System.out.println(value);
        for ( int c = 1; c <= 32; c++ ) {
            System.out.println(value & displayMask);
            // 2进制 << 1
            buf.append(
                    ( value & displayMask ) == 0 ? '0' : '1' );
            value <<= 1;
            if ( c % 8 == 0 ) {
                buf.append( ' ' );
            }
            System.out.println(buf.toString());
        }
        return buf.toString();
    }

    public static void main( String args[] ){
        java_3 app = new java_3();

        app.addWindowListener(
                new WindowAdapter() {
                    //*********Found********
                    public void windowClosing( WindowsEvent e ){
                        System.exit( 0 );
                    }
                }
        );
    }
}