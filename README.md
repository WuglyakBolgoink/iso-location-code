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

[isoDB]: http://www.iso-mme.org/forum/viewtopic.php?f=105&t=441
[isoForum]: http://www.iso-mme.org/forum/
