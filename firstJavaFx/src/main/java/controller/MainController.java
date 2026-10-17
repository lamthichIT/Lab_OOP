package controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainController {

    // === 1. KHU VỰC HIỂN THỊ VIDEO / ẢNH BÌA ===
    @FXML private StackPane mediaContainer;
    @FXML private ImageView videoImageView; // Ông làm Engine vlcj sẽ lấy biến này!
    @FXML private VBox audioCoverPane;
    @FXML private ImageView albumArtImageView;
    @FXML private Label audioTitleLabel;
    @FXML private Label audioArtistLabel;

    // === 2. THANH ĐIỀU KHIỂN (CONTROL BAR) ===
    @FXML private Slider seekBar;
    @FXML private Label currentTimeLabel;
    @FXML private Label totalTimeLabel;
    @FXML private Label nowPlayingLabel;
    @FXML private Button playPauseButton;
    @FXML private Button prevButton;
    @FXML private Button nextButton;
    @FXML private ToggleButton shuffleToggleButton;
    @FXML private Button repeatButton;
    @FXML private Slider volumeSlider;
    @FXML private Button fullscreenButton;

    // === 3. QUẢN LÝ PLAYLIST & HÀNG ĐỢI (QUEUE) ===
    @FXML private Button openFileButton;
    @FXML private Button importM3uButton;
    @FXML private Button exportM3uButton;
    @FXML private ComboBox<String> playlistSelector;
    @FXML private Button newPlaylistButton;
    @FXML private Button renamePlaylistButton;
    @FXML private Button deletePlaylistButton;
    @FXML private ListView<String> playlistListView;
    @FXML private ListView<String> queueListView;
    @FXML private Button addTrackToPlaylistButton;
    @FXML private Button moveUpQueueButton;
    @FXML private Button moveDownQueueButton;
    @FXML private Button removeFromQueueButton;

    // === 4. MENU CHUỘT PHẢI (CONTEXT MENU) ===
    @FXML private MenuItem playNextMenuItem;
    @FXML private MenuItem editMetadataMenuItem;
    @FXML private MenuItem removeTrackMenuItem;

    // Trạng thái giả lập trên UI để bạn test nút bấm
    private boolean isPlaying = false;
    private int repeatMode = 0; // 0: Off, 1: One, 2: All

    @FXML
    public void initialize() {
        // Tự động co giãn khung hình Video theo kích thước cửa sổ
        videoImageView.fitWidthProperty().bind(mediaContainer.widthProperty());
        videoImageView.fitHeightProperty().bind(mediaContainer.heightProperty());

        // Dữ liệu mẫu (Dummy Data) để bạn nhìn thấy giao diện hoạt động ngay khi chạy
        playlistSelector.getItems().addAll("Nhạc Chill Học Bài", "Video Bài Giảng OOP", "Yêu Thích");
        playlistSelector.getSelectionModel().selectFirst();
        playlistListView.getItems().addAll("01. Nơi Này Có Anh.mp3", "02. Lạc Trôi (MV).mp4", "03. Giao hưởng số 9.flac");
        queueListView.getItems().addAll("02. Lạc Trôi (MV).mp4", "03. Giao hưởng số 9.flac");

        // Gắn sự kiện cho các nút bấm
        openFileButton.setOnAction(e -> onOpenFileClicked());
        playPauseButton.setOnAction(e -> onPlayPauseClicked());
        repeatButton.setOnAction(e -> onRepeatClicked());
        fullscreenButton.setOnAction(e -> onFullscreenClicked());
        editMetadataMenuItem.setOnAction(e -> showEditMetadataDialog());
        playNextMenuItem.setOnAction(e -> onPlayNextClicked());
    }

    // =========================================================================
    // CÁC HÀM GIAO DIỆN & SỰ KIỆN ĐỂ NHÓM TRƯỞNG GHÉP LOGIC VÀO
    // =========================================================================

    private void onOpenFileClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Chọn tệp Nhạc hoặc Video");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Media Files", "*.mp3", "*.mp4", "*.mkv", "*.flac", "*.avi")
        );
        File selectedFile = fileChooser.showOpenDialog(openFileButton.getScene().getWindow());
        if (selectedFile != null) {
            nowPlayingLabel.setText("🎵 " + selectedFile.getName());
            // Nếu là file nhạc thì hiện khung ảnh bìa, nếu là video thì hiện videoImageView
            boolean isAudio = selectedFile.getName().endsWith(".mp3") || selectedFile.getName().endsWith(".flac");
            switchMediaViewMode(isAudio);
            // TODO: Nhóm trưởng gọi MediaPlayerService.play(selectedFile) ở đây
        }
    }

    private void onPlayPauseClicked() {
        isPlaying = !isPlaying;
        playPauseButton.setText(isPlaying ? "⏸ Pause" : "▶ Play");
        // TODO: Nhóm trưởng gọi MediaPlayerService.togglePlayPause() ở đây
    }

    private void onRepeatClicked() {
        repeatMode = (repeatMode + 1) % 3;
        String[] labels = {"🔁 Repeat: Off", "🔂 Repeat: One", "🔁 Repeat: All"};
        repeatButton.setText(labels[repeatMode]);
        // TODO: Nhóm trưởng cập nhật trạng thái Repeat trong QueueManager
    }

    private void onFullscreenClicked() {
        Stage stage = (Stage) fullscreenButton.getScene().getWindow();
        stage.setFullScreen(!stage.isFullScreen());
    }

    private void onPlayNextClicked() {
        String selected = playlistListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            queueListView.getItems().add(0, selected); // Đẩy lên đầu hàng đợi
        }
    }

    /**
     * Hàm chuyển đổi chế độ hiển thị giữa Video và Audio (ẩn màn hình video, hiện ảnh bìa)
     */
    public void switchMediaViewMode(boolean isAudioFile) {
        videoImageView.setVisible(!isAudioFile);
        audioCoverPane.setVisible(isAudioFile);
    }

    /**
     * Cửa sổ Dialog chỉnh sửa Metadata (Tên bài, Ca sĩ, Album) dùng GridPane
     */
    private void showEditMetadataDialog() {
        String selectedTrack = playlistListView.getSelectionModel().getSelectedItem();
        if (selectedTrack == null) return;

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Chỉnh sửa thông tin bài hát (Metadata)");
        dialog.setHeaderText("Chỉnh sửa thông tin cho: " + selectedTrack);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 30, 10, 10));

        TextField tfTitle = new TextField(selectedTrack);
        TextField tfArtist = new TextField("Nghệ sĩ chưa rõ");
        TextField tfAlbum = new TextField("Album chưa rõ");
        Button btnChooseArt = new Button("Chọn ảnh bìa...");

        grid.add(new Label("Tên bài hát:"), 0, 0);
        grid.add(tfTitle, 1, 0);
        grid.add(new Label("Ca sĩ:"), 0, 1);
        grid.add(tfArtist, 1, 1);
        grid.add(new Label("Album:"), 0, 2);
        grid.add(tfAlbum, 1, 2);
        grid.add(new Label("Ảnh bìa:"), 0, 3);
        grid.add(btnChooseArt, 1, 3);

        dialog.getDialogPane().setContent(grid);
        ButtonType saveButtonType = new ButtonType("Lưu thay đổi", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

        dialog.showAndWait().ifPresent(response -> {
            if (response == saveButtonType) {
                // TODO: Nhóm trưởng gọi thư viện jaudiotagger lưu thông tin xuống file gốc
                System.out.println("Đã lưu Metadata mới: " + tfTitle.getText() + " - " + tfArtist.getText());
            }
        });
    }

    // Getter quan trọng nhất để ông làm Engine lấy chỗ hiển thị Video
    public ImageView getVideoImageView() {
        return videoImageView;
    }
}