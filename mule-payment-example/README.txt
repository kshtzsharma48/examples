+--------------------+
| Mule Payment Demo  |
+--------------------+
This example is a Mule store which asks the user for a credit card and contact information
and with that information will process payment and will if the payment is successful create
a new Account and Contact in Salesforce along with sending an email.

+---------------------+
| Running the example |
+---------------------+
You can simply copy the pre-built application archive (mule-payment-demo.zip) to the
application folder ($MULE_HOME/apps) and start Mule. Once started make sure
to update the mule.properties file with your information for the specific services.
Once installed the example will be available at the following URL:

    http://localhost:8082/services/checkout

+----------------------+
| Building the example |
+----------------------+
First, make sure you have set the MULE_HOME environment variable as recommended
in Mule's README.txt

You can build the demo by simply running "mvn install".  This will compile the demo
classes and produce a zip file that will be copied into the application folder
($MULE_HOME/apps).

(If you are unable to download the libraries it may be because you are behind a
firewall and have not configured your build tool to use your HTTP proxy.  Please
refer to the following information.)
    Maven users:   http://maven.apache.org/guides/mini/guide-proxies.html