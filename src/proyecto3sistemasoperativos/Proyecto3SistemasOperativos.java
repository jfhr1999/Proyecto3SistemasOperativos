package proyecto3sistemasoperativos;

import Controllers.MainWindowController;
import FileClasses.Directory;
import FileClasses.File;
import FileClasses.Node;
import FileClasses.Shell;
import View.MainWindow;
import javax.swing.JFrame;

public class Proyecto3SistemasOperativos {

    public static void main(String[] args) {
        Shell shell = new Shell();
        
        shell.readCmd();
        
        Node<String> root = createTree();
	printTree(root, " ");
        
        
        
        /*MainWindow view = new MainWindow();
        MainWindowController c = new MainWindowController(view, new Directory("Root", "\\Root"));
        c.view.setVisible(true);
        c.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */
        
    }
    
    private static Node<String> createTree() {
		Node<String> root = new Node<>("root");
				
		Node<String> node1 = root.addChild(new Node<String>("node 1"));
		
		Node<String> node11 = node1.addChild(new Node<String>("node 11"));
		Node<String> node111 = node11.addChild(new Node<String>("node 111"));
		Node<String> node112 = node11.addChild(new Node<String>("node 112"));
		
		Node<String> node12 = node1.addChild(new Node<String>("node 12"));
		
		Node<String> node2 = root.addChild(new Node<String>("node 2"));
		
		Node<String> node21 = node2.addChild(new Node<String>("node 21"));
		Node<String> node211 = node2.addChild(new Node<String>("node 22"));
		return root;
    }
    
    private static <T> void printTree(Node<T> node, String appender) {
		  System.out.println(appender + node.getData());
		  node.getChildren().forEach(each ->  printTree(each, appender + appender));
    }
    
}
