package youtube;

public class Main {

    public static void main(String[] args) {
        var video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("john@domain.com"));

        var mail = new EmailService();
        var encorder = new VideoEncoder();
        var db = new VideoDatabase();

        var processor = new VideoProcessor(mail,db,encorder);
        processor.process(video);
    }
}
