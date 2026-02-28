package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class senateQueue {
    public String predictPartyVictory(String senate) {
        String r="Radiant";
        String d="Dire";
        Queue<Integer> qR=new LinkedList<>();
        Queue<Integer> qD=new LinkedList<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R') qR.offer(i);
            else qD.offer(i);
        }
        while(!qR.isEmpty() && !qD.isEmpty()){
            int qr=qR.poll();
            int qd=qD.poll();
            if(qr<qd){
                qR.offer(qr+n);
            }
            else
                qD.offer(qd+n);
        }
        if(!qR.isEmpty()) return r;
        else return d;
    }
}
