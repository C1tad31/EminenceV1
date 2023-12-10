package me.c1tad31.eminence.announcements;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnnouncementsController {
    @FXML
    private Label announcementsTitle;

    @FXML
    private Label announcementsContent;

    private AnnouncementsService announcementsService = AnnouncementsService.getInstance();

    public void initialize() {
        // Initialize announcements with default values or leave it empty
        updateAnnouncements(announcementsService.getTitle(), announcementsService.getContent());
    }

    public void updateAnnouncements(String title, String content) {
        announcementsTitle.setText(title);
        announcementsContent.setText(content);
    }
}
