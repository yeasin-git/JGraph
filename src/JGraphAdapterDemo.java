/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This program and the accompanying materials are dual-licensed under
 * either
 *
 * (a) the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation, or (at your option) any
 * later version.
 *
 * or (per the licensee's choosing)
 *
 * (b) the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation.
 */
/* ----------------------
 * JGraphAdapterDemo.java
 * ----------------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   -
 *
 * $Id$
 *
 * Changes
 * -------
 * 03-Aug-2003 : Initial revision (BN);
 * 07-Nov-2003 : Adaptation to JGraph 3.0 (BN);
 *
 */


import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import org.jgraph.*;
import org.jgraph.graph.*;

import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;

// resolve ambiguity
import org.jgrapht.graph.DefaultEdge;


/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 * @since Aug 3, 2003
 */
public class JGraphAdapterDemo
    extends JApplet
{
    

    private static final long serialVersionUID = 3256444702936019250L;
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(1000, 600);

    

    //
    private JGraphModelAdapter<String, DefaultEdge> jgAdapter;

    

    /**
     * An alternative starting point for this demo, to also allow running this
     * applet as an application.
     *
     * @param args ignored.
     */
    public static void main(String [] args)
    {
        JGraphAdapterDemo applet = new JGraphAdapterDemo();
        applet.init();

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
        frame.setTitle("JGraphT Adapter to JGraph Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    public void init()
    {
        // create a JGraphT graph
        ListenableGraph<String, DefaultEdge> g =
            new ListenableDirectedMultigraph<String, DefaultEdge>(
                DefaultEdge.class);

        // create a visualization using JGraph, via an adapter
        jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(g);

        JGraph jgraph = new JGraph(jgAdapter);

        adjustDisplaySettings(jgraph);
        getContentPane().add(jgraph);
        resize(DEFAULT_SIZE);

        String v1 = "1";
        String v2 = "2";
        String v3 = "3";
        String v4 = "4";
        
        String v5 = "5";
        String v6 = "6";
        String v7 = "7";
        String v8 = "8";
        
        String v9 = "9";
        String v10 = "10";
        String v11 = "11";
        String v12 = "12";
        
        String v13 = "13";
        String v14 = "14";
        String v15 = "15";
        String v16 = "16";
        
        String vExtraNode = "Extra Node";
        

        // add some sample data (graph manipulated via JGraphT)
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);

        g.addVertex(v9);
        g.addVertex(v10);
        g.addVertex(v11);
        g.addVertex(v12);
        
        g.addVertex(v13);
        g.addVertex(v14);
        g.addVertex(v15);
        g.addVertex(v16);
        
        g.addVertex(vExtraNode);

        // First Column
        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        g.addEdge(v1, v4);
        
        // Second Column
        g.addEdge(v1, v5);
        g.addEdge(v2, v6);
        g.addEdge(v3, v7);
        g.addEdge(v4, v8);
        g.addEdge(v5, v6);
        g.addEdge(v6, v7);
        g.addEdge(v7, v8);
        g.addEdge(v5, v8);

        // Third Column
        g.addEdge(v5, v9);
        g.addEdge(v6, v10);
        g.addEdge(v7, v11);
        g.addEdge(v8, v12);
        g.addEdge(v9, v10);
        g.addEdge(v10, v11);
        g.addEdge(v11, v12);
        g.addEdge(v9, v12);
        
        // Fourth Column
        g.addEdge(v9, v13);
        g.addEdge(v10, v14);
        g.addEdge(v11, v15);
        g.addEdge(v12, v16);
        g.addEdge(v13, v14);
        g.addEdge(v14, v15);
        g.addEdge(v15, v16);
        g.addEdge(v13, v16);
       
        // First Column to Fourth Column
        g.addEdge(v1, v13);
        g.addEdge(v2, v14);
        g.addEdge(v3, v15);
        g.addEdge(v4, v16);
        
        // Extra Node Connect
        g.addEdge(vExtraNode, v15);
        

        // position vertices nicely within JGraph component
        // First Column
        positionVertexAt(v1, 20, 30);
        positionVertexAt(v2, 50, 130);
        positionVertexAt(v3, 50, 230);
        positionVertexAt(v4, 20, 330);
        
        // Second Column
        positionVertexAt(v5, 200, 50);
        positionVertexAt(v6, 230, 150);
        positionVertexAt(v7, 230, 250);
        positionVertexAt(v8, 200, 350);
        
        // Third Column
        positionVertexAt(v9, 380, 50);
        positionVertexAt(v10, 410, 150);
        positionVertexAt(v11, 410, 250);
        positionVertexAt(v12, 380, 350);
        
        // Fourth Column
     // Third Column
        positionVertexAt(v13, 560, 30);
        positionVertexAt(v14, 590, 130);
        positionVertexAt(v15, 590, 230);
        positionVertexAt(v16, 560, 330);
        
        //Extra Node
        positionVertexAt(vExtraNode, 750, 500);
        

        // that's all there is to it!...
    }

    private void adjustDisplaySettings(JGraph jg)
    {
        jg.setPreferredSize(DEFAULT_SIZE);

        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }

    @SuppressWarnings("unchecked") // FIXME hb 28-nov-05: See FIXME below
    private void positionVertexAt(Object vertex, int x, int y)
    {
        DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
        Rectangle2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
                bounds.getWidth(),
                bounds.getHeight());

        GraphConstants.setBounds(attr, newBounds);

        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
        jgAdapter.edit(cellAttr, null, null, null);
    }

    

    /**
     * a listenable directed multigraph that allows loops and parallel edges.
     */
    private static class ListenableDirectedMultigraph<V, E>
        extends DefaultListenableGraph<V, E>
        implements DirectedGraph<V, E>
    {
        private static final long serialVersionUID = 1L;

        ListenableDirectedMultigraph(Class<E> edgeClass)
        {
            super(new DirectedMultigraph<V, E>(edgeClass));
        }
    }
}

// End JGraphAdapterDemo.java
