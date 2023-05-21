<?php
    $to = "ccatura@gmail.com";
    $subject = $_POST['subject'];
    $email = $_POST['email'];
    $name = $_POST['name'];

    $message = "New message from your portfolio page from <strong>" . $name . "</strong> (" . $email . ")<br><hr>";
    $message .= $_POST['message'];

    $header = "From: " . $name . " <" . $email . "> \r\n";
    //  $header .= "Cc:afgh@somedomain.com \r\n";
    $header .= "MIME-Version: 1.0\r\n";
    $header .= "Content-type: text/html\r\n";

    $sendmail = mail ($to, $subject, $message, $header);

    if( $sendmail == true ) {
        echo "<h1>Your message was sent successfully!</h1><h3><a href='./'>Click here to go back</a></h3>";
        echo $message;
        echo $header;
    } else {
        echo "<h1>Message could not be sent.</h1><h3><a href='./'>Click here to try again</a></h3>";
    }
?>