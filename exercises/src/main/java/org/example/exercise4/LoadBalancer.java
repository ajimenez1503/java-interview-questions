package org.example.exercise4;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadBalancer {
    List<Node> instances;
    int lastNodeProvided;


    public LoadBalancer() {
        instances = new ArrayList<>();
        lastNodeProvided = 0;
    }

    public boolean registry(String address) throws Exception {

        if (instances.size() >= 10) {
            throw new Exception("cannot register more than 10 instances");
        }
        Node newNode = new Node(address);
        if (instances.contains(newNode)) {
            throw new Exception("instances is already registered");
        }
        return instances.add(newNode);
    }

    public Node get() throws Exception {
        if (instances.size() == 0) {
            throw new Exception("cannot get an instances");
        }
        Random random = new Random();
        return instances.get(random.nextInt(instances.size()));
    }
}