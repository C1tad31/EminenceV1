package me.c1tad31.eminence.announcements;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnnouncementsService {
    private static AnnouncementsService instance;
    private String title;
    private String content;

    private AnnouncementsService() {
        // Private constructor to enforce singleton pattern
    }

    public static AnnouncementsService getInstance() {
        if (instance == null) {
            instance = new AnnouncementsService();
        }
        return instance;
    }

    public void updateAnnouncements(String title, String content) {
        this.title = title;
        this.content = content;
    }
}