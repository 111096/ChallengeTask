package net.challenge.service;

import net.challenge.base.Base;
import net.challenge.entity.Tick;
import net.challenge.entity.Statistics;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by moust on 5/24/2021.
 */
@Service
public class StatisticService extends Base {

    public Statistics getStatistics() {
        Statistics s = new Statistics();
        int diff;
        Hashtable<String, Tick> instrumentList = readFile();
        long count = 0;
        for (Map.Entry<String, Tick> i : instrumentList.entrySet()) {
            diff = (int) (System.currentTimeMillis() - i.getValue().getTimestamp());
            if (diff <= Base.TIME) {
                if (s.getMax() < i.getValue().getPrice()) {
                    s.setMax(i.getValue().getPrice());
                }
                if (s.getMin() > i.getValue().getPrice()) {
                    s.setMin(i.getValue().getPrice());
                }
                s.setAvg(s.getAvg() + i.getValue().getPrice());
                count++;
                s.setCount(count);
            }
        }
        if (s.getCount() != 0) {
            s.setAvg(s.getAvg() / s.getCount());
        }
        return s;

    }

}
