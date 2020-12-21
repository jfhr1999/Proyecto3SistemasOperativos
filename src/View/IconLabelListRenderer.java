/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author Gloriana
 */
public class IconLabelListRenderer extends DefaultListCellRenderer{
    private JLabel label;
    private final String folderPath = "src\\main\\resources\\folder-2x.png";
    private final String filePath = "src\\main\\resources\\file-2x.png";
    
    public IconLabelListRenderer(){
        label = new JLabel();
        label.setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index, boolean selected, boolean expanded){
        ListItem item = (ListItem)value;
        
        if(item.isDir){
            this.label.setIcon(new ImageIcon(folderPath));
        } else{
            this.label.setIcon(new ImageIcon(filePath));
        }
        
        this.label.setText(item.label);
        this.label.setToolTipText(item.label);
        
        if(selected){
            label.setBackground(list.getSelectionBackground());
            label.setForeground(list.getSelectionForeground());
        } else{
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }
        return label;
    }
}
