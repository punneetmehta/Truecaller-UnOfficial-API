<?PHP

$APIToken = ""; // PHPHive Truecaller API Token, Obtain it from https://tcapi.phphive.info/console/

$no = ""; // Any Number You want to Search 

search($no); // echo Details like Name, Internet Address ( including Profile Picutre, Email, Facebook & Twitter ), Spam Score, Spammer Type etc.

function search($no){

$uri = 'https://tcapi.phphive.info/'.$APIToken.'/search/'.$no;
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
