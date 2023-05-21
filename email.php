<?php
    $to = "ccatura@gmail.com";
    $subject = $_POST['subject'];
    $email = $_POST['email'];

    $message = $_POST['message'];

    $header = "From:'$email' \r\n";
    //  $header .= "Cc:afgh@somedomain.com \r\n";
    $header .= "MIME-Version: 1.0\r\n";
    $header .= "Content-type: text/html\r\n";

    $sendmail = mail ($to, $subject, $message, $header);

    if( $sendmail == true ) {
        echo "<h1>Message sent successfully!</h1>";
    } else {
        echo "<h1>Message could not be sent.</h1>";
    }
?>