<?php
    $to = "ccatura@gmail.com";
    $subject = $_POST['subject'];
    $email = $_POST['email'];
    $name = $_POST['name'];
    $good_to_go = $_POST['good-to-go'];

    $message = "Good to go? " . $good_to_go . "<br>";
    $message .= "New message from your portfolio page from <strong>" . $name . "</strong> (" . $email . ")<br><hr>";
    $message .= $_POST['message'];

    $header[] = "From: $email";
    $header[] = "MIME-Version: 1.0";
    $header[] = "Content-type: text/html";

    if($good_to_go == 'true') {
        $sendmail = mail($to, $subject, $message, implode("\r\n", $header));
    
        if( $sendmail == true ) {
            echo "<h1>Your message was sent successfully!</h1><h3><a href='#' onclick='window.close();return false;'>Click here to close this tab.</a></h3>";
            // echo $message . "<br><br>";
            // echo implode("\r\n", $header);
        } else {
            echo "<h1>Message could not be sent.</h1><h3><a href='#' onclick='window.close();return false;'>Click here to try again.</a></h3>";
        }
    }
?>

