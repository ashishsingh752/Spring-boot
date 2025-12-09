package as.spring.journal.controller;

import as.spring.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {

    private Map<String, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/{id}")
    public JournalEntry getById(@PathVariable String id) {
        return journalEntries.get(id);
    }

    @PostMapping
    public String create(@RequestBody JournalEntry journalEntry) {
        journalEntries.put(journalEntry.getId(), journalEntry);
        return "Created successfully";
    }

    @PutMapping("/{id}")
    public String update(
            @PathVariable String id,
            @RequestBody JournalEntry updatedEntry) {

        if (!journalEntries.containsKey(id)) {
            return "Entry not found";
        }

        journalEntries.put(id, updatedEntry);
        return "Updated successfully";
    }

    @PatchMapping("/{id}")
    public String updatePartial(
            @PathVariable String id,
            @RequestBody Map<String, Object> updates) {

        JournalEntry existing = journalEntries.get(id);

        if (existing == null) {
            return "Entry not found";
        }

        if (updates.containsKey("title")) {
            existing.setTitle((String) updates.get("title"));
        }
        if (updates.containsKey("content")) {
            existing.setContent((String) updates.get("content"));
        }

        // Save back
        journalEntries.put(id, existing);
        return "Partially updated successfully";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        if (!journalEntries.containsKey(id)) {
            return "Entry not found";
        }

        journalEntries.remove(id);
        return "Deleted successfully";
    }
}
