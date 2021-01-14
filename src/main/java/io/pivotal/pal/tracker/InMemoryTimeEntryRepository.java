package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository{

    Map<Long, TimeEntry> memoryMap = new HashMap<>();
    long currentId = 1L;
    long[] idArr = {1L, 2L, 3L, 4L, 5L, 6L};

    public TimeEntry create(TimeEntry any) {
        //int mapSize = memoryMap.size();
        long id = currentId++;
        TimeEntry timeEntry = new TimeEntry(id, any);
        memoryMap.put(id, timeEntry);
        return memoryMap.get(id);
    }

    public TimeEntry find(Long timeEntryId) {
        return memoryMap.get(timeEntryId);
    }

    public List<TimeEntry> list() {
        return new ArrayList(memoryMap.values());
    }

    public TimeEntry update(Long eq, TimeEntry any) {
        TimeEntry timeEntry = new TimeEntry(eq, any);
        memoryMap.replace(eq, timeEntry);
        return memoryMap.get(eq);
    }

    public void delete(Long timeEntryId) {
        memoryMap.remove(timeEntryId);
    }
}
