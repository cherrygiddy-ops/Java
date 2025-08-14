package youtube;

public class VideoProcessor {
    private NotificationService emailService;
    private Database database ;
    private Encoder  encoder ;

    public VideoProcessor(NotificationService emailService, Database database, Encoder encoder) {
        this.emailService = emailService;
        this.database = database;
        this.encoder = encoder;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        emailService.sendEmail(video.getUser());
    }
}

