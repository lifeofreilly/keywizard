<#-- @ftlvariable name="" type="com.gmail.lifeofreilly.keywizard.views.KeyWizardView" -->
<#escape x as x?html>
<html>
<body>
<p>Address: ${keyRepresentation.address}</p>
<p>Private Key: ${keyRepresentation.privKey}</p>
<p>Private Key HEX: ${keyRepresentation.hexKey}</p>
<p>Private Key WIF: ${keyRepresentation.wifKey}</p>
<p><a href="${keyRepresentation.addressInfo}">Address Info</a></p>
</body>
</html>
</#escape>