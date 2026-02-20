<?php
    $to = "ccatura@gmail.com";
    $email = $_POST['email'];
    $name = $_POST['name'];
    $good_to_go = $_POST['good-to-go'];

    $header[] = "From: $email";
    $header[] = "MIME-Version: 1.0";
    $header[] = "Content-type: text/html";

    if($good_to_go == 'true') {
        $subject = $_POST['subject'];
        $message  = "Good to go? " . $good_to_go . "<br>";
        $message .= "New message from your portfolio page from <strong>" . $name . "</strong> (" . $email . ")<br><hr>";
        $message .= $_POST['message'];
    } else {
        http_response_code(404);
        // include('my_404.php'); // provide your own HTML for the error page
        die();

        // $subject = "Spam from my portfolio webpage";
        // $message  = "Stopped spammer:<br>";
        // $message .= "Name: " . $name . "<br>";
        // $message .= "Email: " . $email . "<br>";
        // $message .= "Message: " . $_POST['message'] . "<br>";
    }

    $sendmail = mail($to, $subject, $message, implode("\r\n", $header));

    if( $sendmail == true ) {
        echo "<h1>Your message was sent successfully!</h1><h3><a href='#' onclick='window.close();return false;'>Click here to close this tab.</a></h3>";
        // echo $message . "<br><br>";
        // echo implode("\r\n", $header);
    } else {
        echo "<h1>Message could not be sent.</h1><h3><a href='#' onclick='window.close();return false;'>Click here to try again.</a></h3>";
    }
?>

