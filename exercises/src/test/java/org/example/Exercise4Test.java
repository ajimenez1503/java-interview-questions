package org.example;

import org.example.exercise4.LoadBalancer;
import org.example.exercise4.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Exercise4Test {
    @Test
    public void basic() {
        LoadBalancer loadBalancer = new LoadBalancer();
        try {
            assertTrue(loadBalancer.registry("1.1.1.0"));
            assertTrue(loadBalancer.registry("1.1.1.1"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void randomGet() {
        LoadBalancer loadBalancer = new LoadBalancer();
        try {
            assertTrue(loadBalancer.registry("1.1.1.0"));
            assertTrue(loadBalancer.registry("1.1.1.1"));
            boolean gotNode1 = false, gotNode2 = false;
            int i = 0;
            while (!gotNode1 || !gotNode2) {
                Node node = loadBalancer.get();
                if (node.getAddress() == "1.1.1.0") {

                    gotNode1 = true;
                }
                if (node.getAddress() == "1.1.1.1") {
                    gotNode2 = true;
                }
                if (++i > 10000) {
                    break;
                }
            }
            assertTrue(gotNode1);
            assertTrue(gotNode2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getEmpty() {
        LoadBalancer loadBalancer = new LoadBalancer();
        try {
            Node node = loadBalancer.get();
        } catch (Exception e) {
            assertEquals("cannot get an instances", e.getMessage());
        }
    }

    @Test
    public void moreThan10Instances() {
        LoadBalancer loadBalancer = new LoadBalancer();
        try {
            assertTrue(loadBalancer.registry("1.1.1.0"));
            assertTrue(loadBalancer.registry("1.1.1.1"));
            assertTrue(loadBalancer.registry("1.1.1.2"));
            assertTrue(loadBalancer.registry("1.1.1.3"));
            assertTrue(loadBalancer.registry("1.1.1.4"));
            assertTrue(loadBalancer.registry("1.1.1.5"));
            assertTrue(loadBalancer.registry("1.1.1.6"));
            assertTrue(loadBalancer.registry("1.1.1.7"));
            assertTrue(loadBalancer.registry("1.1.1.8"));
            assertTrue(loadBalancer.registry("1.1.1.9"));
            assertTrue(loadBalancer.registry("1.1.1.10"));
            assertTrue(loadBalancer.registry("1.1.1.11"));
        } catch (Exception e) {
            assertEquals("cannot register more than 10 instances", e.getMessage());
        }
    }

    @Test
    public void registerSameInstancesTwice() {
        LoadBalancer loadBalancer = new LoadBalancer();
        try {
            assertTrue(loadBalancer.registry("1.1.1.0"));
            assertTrue(loadBalancer.registry("1.1.1.0"));
        } catch (Exception e) {
            assertEquals("instances is already registered", e.getMessage());
        }
    }

}
