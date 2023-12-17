package com.example;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.scene.layout.HBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private ImageView thumbnail;

    @FXML
    private Label height;

    @FXML
    private Label width;

    @FXML
    private Label imageSize;

    @FXML
    private ComboBox<String> dropDown;

    @FXML
    private Button uploadButton;

    @FXML
    private Button downloadButton;

    @FXML
    private Label fileLocationLabel;

    @FXML
    private HBox thumbnailsContainer; // Updated to HBox

    private List<File> uploadedFiles = new ArrayList<>(); // Updated to support multiple files

    // Set the combobox items
    public void initialize() {
        dropDown.getItems().addAll("png", "jpeg", "jpg");
        dropDown.setValue(dropDown.getItems().get(0));
    }

    @FXML
    public void uploadImageButton(ActionEvent e) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Select image files");
        List<File> selectedFiles = fc.showOpenMultipleDialog(null);

        if (selectedFiles != null && !selectedFiles.isEmpty()) {
            for (File selectedFile : selectedFiles) {
                // Display thumbnails
                Image imageFile = new Image(selectedFile.toURI().toString());
                ImageView thumbnail = new ImageView(imageFile);
                thumbnail.setFitWidth(100);
                thumbnail.setFitHeight(100);
                thumbnailsContainer.getChildren().add(thumbnail);

                // Save the uploaded files for later use
                uploadedFiles.add(selectedFile);
            }

            // Display properties of the first image
            displayImageProperties(new Image(uploadedFiles.get(0).toURI().toString()));
        } else {
            fileLocationLabel.setText("No files selected");
        }
    }

    @FXML
    private void convertDownloadButton(ActionEvent e) {
        // Get the selected format from the ComboBox
        String selectedFormat = dropDown.getValue();

        if (!uploadedFiles.isEmpty()) {
            for (File uploadedFile : uploadedFiles) {
                try {
                    // Convert each image to the selected format
                    BufferedImage bufferedImage = ImageIO.read(uploadedFile);

                    // Create a FileChooser to select the download location
                    FileChooser fc = new FileChooser();
                    fc.setTitle("Select a download location");

                    // Set the initial file name based on the image file name
                    String defaultFileName = "converted_image." + selectedFormat;
                    fc.setInitialFileName(defaultFileName);

                    // Create an ExtensionFilter for the selected format and add it to the FileChooser
                    fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedFormat.toUpperCase() + " files (*." + selectedFormat + ")", "*." + selectedFormat));

                    // Show the Save Dialog
                    File downloadLocation = fc.showSaveDialog(null);

                    if (downloadLocation != null) {
                        ImageIO.write(bufferedImage, selectedFormat, downloadLocation);

                        // Display a success message
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Image saved");
                        alert.setContentText("The converted image was saved to \n" + downloadLocation);
                        alert.showAndWait();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void displayImageProperties(Image image) {
        fileLocationLabel.setText(""); // You might want to improve how you display multiple file locations
        width.setText(String.valueOf(image.getWidth()));
        height.setText(String.valueOf(image.getHeight()));
        imageSize.setText(""); // You might want to improve how you display multiple image sizes
    }
}

