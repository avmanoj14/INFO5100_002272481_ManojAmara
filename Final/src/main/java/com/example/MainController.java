package com.example;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainController {

    @FXML
    private ImageView thumbnail;

    @FXML
    private ImageView image;

    @FXML
    private MenuItem jpeg;

    @FXML
    private MenuItem jpg;

    @FXML
    private MenuItem png;

    @FXML
    private Button uploadButton;

    @FXML
    private Button downloadButton;

    @FXML
    private Label fileLocationLabel;

    @FXML
    private Label height;

    @FXML
    private Label width;

    @FXML
    private Label imageSize;

    @FXML
    private ComboBox<String> dropDown;

    // Set the combobox items
    public void initialize() {
        dropDown.getItems().addAll("png", "jpeg", "jpg");
        dropDown.setValue(dropDown.getItems().get(0));
    }

    @FXML
    public void uploadImageButton(ActionEvent e) {
//   1. Take one or more image file(s) as input
//   2. Develop GUI to allow user to upload image file(s) from desktop/laptop

        FileChooser fc = new FileChooser();
        fc.setTitle("Select an image file");
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
//            System.out.println(selectedFile.getAbsolutePath().getClass().getName());
            // Set the text of the location label to the file path

            fileLocationLabel.setText(selectedFile.getAbsolutePath());
            image = new ImageView();
            Image imageFile = new Image(selectedFile.toURI().toString());
            // Set the image to a valid Image object
            image.setImage(imageFile);
//   3. When uploaded, show image(s) thumbnail(s) (100x100) to users on GUI

            thumbnail.setImage(image.getImage());
            thumbnail.setFitWidth(100);
            thumbnail.setFitHeight(100);

//   4. Also, show image properties (height, width, size, location, etc.)

            width.setText(String.valueOf(imageFile.getWidth()));
            height.setText(String.valueOf(imageFile.getHeight()));
            // Calculate the size of the image file in bytes
            long imageFileSize = selectedFile.length();
            // Set the text of the imageSize label to the file size
            imageSize.setText(String.valueOf(imageFileSize));

        } else {
            System.out.println("File is not Valid");
            fileLocationLabel.setText("No files selected");
        }
    }

    @FXML
    private void convertDownloadButton(ActionEvent e) {
        // Get the selected format from the ComboBox
        String selectedFormat = dropDown.getValue();

        // Use the file path from the fileLocationLabel to create a File object
        File selectedFile = new File(fileLocationLabel.getText());
        if (selectedFile != null) {
            try {
                // Read the image file into a BufferedImage object
                // 5.   Use Image IO/ImageMagick/JMagick to convert image to various formats
                // 6.   Develop GUI to allow user to select which format(s) to convert the image(s) to

                BufferedImage imageFile = ImageIO.read(selectedFile);
                BufferedImage awtImage = new BufferedImage((int) imageFile.getWidth(), (int) imageFile.getHeight(), BufferedImage.TYPE_INT_RGB);

                // Create a FileChooser to select the download location
                FileChooser fc = new FileChooser();
                fc.setTitle("Select a download location");

                // Get the original file's name, remove the existing file extension, and append the new file extension
                String defaultFileName = selectedFile.getName();
                int index = defaultFileName.lastIndexOf('.');
                if (index != -1) {
                    defaultFileName = defaultFileName.substring(0, index);
                }
                defaultFileName += "." + selectedFormat;
                fc.setInitialFileName(defaultFileName);

                // Create an ExtensionFilter for the selected format and add it to the FileChooser
                fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(selectedFormat.toUpperCase() + " files (*." + selectedFormat + ")", "*." + selectedFormat));
                //  7.  Develop GUI to allow users to download converted images
                File downloadLocation = fc.showSaveDialog(null);
                if (downloadLocation != null) {
                    // Convert the BufferedImage to a JavaFX Image object
                    Image fxImage = SwingFXUtils.toFXImage(imageFile, null);

                    // Convert the JavaFX Image object to a BufferedImage object
                    BufferedImage bufferedImage = SwingFXUtils.fromFXImage(fxImage, awtImage);
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