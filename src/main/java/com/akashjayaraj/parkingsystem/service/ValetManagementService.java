package com.akashjayaraj.parkingsystem.service;

import com.akashjayaraj.parkingsystem.model.Valet;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ValetManagementService {

    private List<Valet> valets = new ArrayList<>();
    private Set<Valet> occupiedValets = new HashSet<>();


    public void addValet(Valet valet) {
        valets.add(valet);
    }

    public Valet getValetWithMoreSkill() {
        PriorityQueue<Valet> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getSkillRank(), a.getSkillRank()));
        Valet valet = maxHeap.poll();
        while(!maxHeap.isEmpty() && occupiedValets.contains(valet)) {
            valet = maxHeap.poll();
        }
        occupiedValets.add(valet);
        assert valet != null;
        valet.setAvailable(false);
        return valet;
    }

    public void freeValet(Valet valet) {
        valet.setAvailable(true);
        occupiedValets.remove(valet);
    }
}
