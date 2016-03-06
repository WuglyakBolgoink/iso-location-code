# iso-location-code
Parsing ISO [Location code][isoForum] from [MDB-file][isoDB] and export data into JSON-file

![ISO TS14399](images/iso_headerLeft.gif)

## Usage: 
```
java -jar mdbgrabber.jar
```

## Help: MDBGrabber
```
 -?                  Show help
 -h,--help           Show help
 -i,--input <arg>    Path until *.MDB database
 -o,--output <arg>   Path until output JSON file, if not getting export in
                     'out.json'-file
 -s,--stat           Show stat
 -v,--version        Show version
```

## ISO Location Code
![ISO code](https://cdn.rawgit.com/cyberkatze/iso-location-code/master/images/ilc.svg)

For example [**S0CONT000015EV00**]:

Code name | Type | Description (Germany)
:---: | :---: | ---
S | Test Object |Schlitten
0 | Seat Position | Undefiniert
CONT | Main Location | Digital-Kontakt
00 | Fine Location 1 | Undefiniert
00 | Fine Location 2 | Nicht Definiert15
15 | Fine Location 3 | 15.
EV | Dimension | Ereignis
0 | Direction | ohne
0 | Filter Class | Unfiltered

## JSON-File:

On each section there is 'rex'-Attribute.  
For example in original table **"MME_TEST_OBJECTS"** there is column with name **"TEST_OBJECT"**, and same for other tables. In my case, I will have only one attribute in all objects in JSON-file.

```json
{
  "F1": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "??",
      "expired": false,
      "rex": "..",
      "sortkey": "9000",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "text_l1": "??",
      "version": 1
    }, ...
  ],
  "PO": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "?",
      "expired": false,
      "rex": ".",
      "sortkey": "",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "text_l1": "?",
      "version": 1
    }, ...
  ],
  "ML": [
    {
      "last_change": "",
      "text_l2": "Undefiniert",
      "expired": false,
      "rex": "0000",
      "remarks": "",
      "last_change_text": "",
      "type": "Others",
      "date": "14.10.1999",
      "text_l1": "Undefined",
      "picture_shortname": "",
      "version": 1,
      "history": "",
      "sortkey": "99999999"
    }, ...
  ],
  "F3": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "??",
      "expired": false,
      "rex": "..",
      "sortkey": "9000",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "picture_shortname": "",
      "text_l1": "??",
      "version": 1
    }, ...
  ],
  "FC": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "?",
      "expired": false,
      "rex": ".",
      "sortkey": "",
      "last_change_text": "",
      "remarks": "",
      "date": "15.05.2007",
      "text_l1": "?",
      "version": 31
    }, ...
  ],
  "F2": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "??",
      "expired": false,
      "rex": "..",
      "sortkey": "9000",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "text_l1": "??",
      "version": 1
    }, ...
  ],
  "PD": [
    {
      "last_change": "",
      "text_l2": "Undefiniert",
      "expired": false,
      "rex": "..",
      "time_exp": "",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "length_exp": "",
      "amount_of_substance_exp": "",
      "text_l1": "Undefined",
      "temperature_exp": "",
      "version": 1,
      "history": "",
      "electric_current_exp": "",
      "mass_exp": "",
      "sortkey": "",
      "default_unit": "1",
      "luminous_intensity_exp": ""
    }, ...
  ],
  "TO": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "?",
      "expired": false,
      "rex": ".",
      "sortkey": "",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "text_l1": "?",
      "version": 1
    }, ...
  ],
  "DI": [
    {
      "history": "",
      "last_change": "",
      "text_l2": "?",
      "expired": false,
      "rex": ".",
      "sortkey": "",
      "last_change_text": "",
      "remarks": "",
      "date": "14.10.1999",
      "text_l1": "?",
      "version": 1
    }, ...
  ]
}
```

## TODO

- [ ] add option to save dafeault column name
- [ ] export in CSV-format
 
<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="704px" height="354px" version="1.1"><defs><linearGradient x1="0%" y1="0%" x2="0%" y2="100%" id="mx-gradient-dae8fc-1-7ea6e0-1-s-0"><stop offset="0%" style="stop-color:#DAE8FC"/><stop offset="100%" style="stop-color:#7EA6E0"/></linearGradient></defs><g transform="translate(0.5,0.5)"><g transform="translate(190.5,0.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="510" height="70" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 511px; height: 71px; overflow: hidden; white-space: nowrap; text-align: center;"><table width="510" border="1" align="center" cellpadding="4" style="border-collapse: collapse"><tbody><tr style="background-color: #a7c942 ; color: #ffffff ; border: 1px solid #98bf21"><td><b><font color="#000000">Sample Code<br /></font></b></td><th align="left"><font color="#000000">1</font></th><th align="left"><font color="#000000">1</font></th><th align="left"><font color="#000000">NECK</font></th><td><b><font color="#000000">UP<br /></font></b></td><td><b><font color="#000000">00<br /></font></b></td><td><b><font color="#000000">H3<br /></font></b></td><td><b><font color="#000000">MO<br /></font></b></td><td><b><font color="#000000">X<br /></font></b></td><td><b><font color="#000000">B</font></b></td></tr><tr style="border: 1px solid #98bf21"><td><b>Form Selection<br /></b></td><td>TO</td><td>PO</td><td>ML</td><td>F1<br /></td><td>F2<br /></td><td>F3<br /></td><td>PD<br /></td><td>DI<br /></td><td>FC<br /></td></tr><tr style="background-color: #eaf2d3 ; border: 1px solid #98bf21"><td><b>Code Position<br /></b></td><td>1</td><td>2</td><td>3-4-5-6</td><td>7-8<br /></td><td>9-10<br /></td><td>11-12<br /></td><td>13-14<br /></td><td>15<br /></td><td>16<br /></td></tr></tbody></table></div></foreignObject><text x="255" y="41" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">[Not supported by viewer]</text></switch></g><path d="M 161 100.9 L 331.55 100.9 L 331.55 77.61" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 331.55 72.36 L 335.05 79.36 L 331.55 77.61 L 328.05 79.36 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="91" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(70.5,94.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="60" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 61px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Test Object<br /></div></div></foreignObject><text x="30" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Test Object&lt;br&gt;</text></switch></g><path d="M 161 131.24 L 368.1 131.24 L 368.1 77.61" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 368.1 72.36 L 371.6 79.36 L 368.1 77.61 L 364.6 79.36 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="121" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(78.5,124.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="44" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 45px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Position</div></div></foreignObject><text x="22" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Position</text></switch></g><path d="M 161 160.9 L 419.83 160.9 L 419.83 78.3" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 419.83 73.05 L 423.33 80.05 L 419.83 78.3 L 416.33 80.05 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="1" y="151" width="160" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(10.5,154.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="141" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 142px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Transducer Main Location<br /></div></div></foreignObject><text x="71" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Transducer Main Location&lt;br&gt;</text></switch></g><path d="M 161 280.9 L 610.17 280.9 L 610.17 79.68" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 610.17 74.43 L 613.67 81.43 L 610.17 79.68 L 606.67 81.43 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="271" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(71.5,274.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="59" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 60px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Dimension</div></div></foreignObject><text x="30" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Dimension</text></switch></g><path d="M 161 311.24 L 653.62 311.24 L 653.62 78.99" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 653.62 73.74 L 657.12 80.74 L 653.62 78.99 L 650.12 80.74 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="301" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(76.5,304.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="49" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 50px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Direction</div></div></foreignObject><text x="25" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Direction</text></switch></g><path d="M 161 340.9 L 686.03 340.9 L 686.03 81.06" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 686.03 75.81 L 689.53 82.81 L 686.03 81.06 L 682.53 82.81 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="331" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(70.5,334.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="61" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 62px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Filter Class<br /></div></div></foreignObject><text x="31" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Filter Class&lt;br&gt;</text></switch></g><path d="M 161 191.24 L 466.72 191.24 L 466.72 77.61" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 466.72 72.36 L 470.22 79.36 L 466.72 77.61 L 463.22 79.36 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="181" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(58.5,184.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="84" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 85px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Fine Location 1<br /></div></div></foreignObject><text x="42" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Fine Location 1&lt;br&gt;</text></switch></g><path d="M 161 220.9 L 507.41 220.9 L 507.41 78.99" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 507.41 73.74 L 510.91 80.74 L 507.41 78.99 L 503.91 80.74 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="211" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(58.5,214.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="84" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 85px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Fine Location 2<br /></div></div></foreignObject><text x="42" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Fine Location 2&lt;br&gt;</text></switch></g><path d="M 161 251.24 L 557.07 251.24 L 557.07 78.3" fill="none" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><path d="M 557.07 73.05 L 560.57 80.05 L 557.07 78.3 L 553.57 80.05 Z" fill="#000000" stroke="#000000" stroke-miterlimit="10" pointer-events="none"/><rect x="41" y="241" width="120" height="20" fill="url(#mx-gradient-dae8fc-1-7ea6e0-1-s-0)" stroke="#6c8ebf" pointer-events="none"/><g transform="translate(58.5,244.5)"><switch><foreignObject style="overflow:visible;" pointer-events="all" width="84" height="12" requiredFeatures="http://www.w3.org/TR/SVG11/feature#Extensibility"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; font-size: 12px; font-family: Helvetica; color: rgb(0, 0, 0); line-height: 1.2; vertical-align: top; width: 85px; white-space: nowrap; text-align: center;"><div style="display:inline-block;text-align:inherit;text-decoration:inherit;" xmlns="http://www.w3.org/1999/xhtml">Fine Location 3<br /></div></div></foreignObject><text x="42" y="12" fill="#000000" text-anchor="middle" font-size="12px" font-family="Helvetica">Fine Location 3&lt;br&gt;</text></switch></g></g></svg>

[isoDB]: http://www.iso-mme.org/forum/viewtopic.php?f=105&t=441
[isoForum]: http://www.iso-mme.org/forum/
