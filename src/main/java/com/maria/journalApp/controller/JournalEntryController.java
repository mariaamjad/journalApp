package com.maria.journalApp.controller;

import com.maria.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @GetMapping
    public List<JournalEntry> getAll() {
        return (new ArrayList<>(journalEntries.values()));
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable Long myId) {
        journalEntries.remove(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable Long myId, @RequestBody JournalEntry entry) {
        return journalEntries.replace(myId, entry);
    }
}
