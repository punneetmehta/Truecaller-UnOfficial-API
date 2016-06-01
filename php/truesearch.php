<?PHP


$no = ""; // Any Number You want to Search 

search($no); // echo Details like Name, Internet Address ( including Email, Facebook & Twitter ), Spam Score, Spammer Type etc.

searchProfilePic($no); // echo ProfilePic Url ( if Available on TrueCaller )

function search($no){

$uri = 'https://tcapi.phphive.info/search/'.$no;
$ch = curl_init($uri);
curl_setopt_array($ch, array(
    CURLOPT_HTTPHEADER  => array('X-User: PHPHive'),
    CURLOPT_RETURNTRANSFER  =>true,
 CURLOPT_SSL_VERIFYHOST => false,
 CURLOPT_SSL_VERIFYPEER => false,
    CURLOPT_VERBOSE     => 1
));
$response = curl_exec($ch);
curl_close($ch);
echo $response;

}

function searchProfilePic($no){

$uri = 'https://tcapi.phphive.info/pic/'.$no;
$ch = curl_init($uri);
curl_setopt_array($ch, array(
    CURLOPT_HTTPHEADER  => array('X-User: PHPHive'),
    CURLOPT_RETURNTRANSFER  =>true,
 CURLOPT_SSL_VERIFYHOST => false,
 CURLOPT_SSL_VERIFYPEER => false,
    CURLOPT_VERBOSE     => 1
));
$response = curl_exec($ch);
curl_close($ch);
echo $response;

}

?>
