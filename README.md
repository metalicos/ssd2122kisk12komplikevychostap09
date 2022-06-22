# `Software systems design`
## @author Ostap Komplikevych
## @mentor andrii.s.shpitser@lpnu.ua

### Task details:
```
Task 3. Load SF (BEF):
1. Implement SF load and parse.
2. The tool should show the loaded sequence and element number.
3. Required steps.
```
### USER GUIDE:
```
1. Clone repository
2. Install Coretto java11 -> https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html
3. Use manual for java instalation -> https://phoenixnap.com/kb/install-java-windows
4. After succesfull previous steps please open terminal
5. Navigate to cloned repository and stay at /JAR folder
6. When you inside of /JAR folder write command
java -jar seq.jar -h
7. You should see help info from the program:
Usage: mainCommand [-hV] [-n=<sequenceNumber>] [-s=<sequenceFormula>]
                   [-sf=<sequenceFilePath>]
  -h, --help      Show this help message and exit.
  -n, --number=<sequenceNumber>
                  Sequence number
  -s, --sequence=<sequenceFormula>
                  Manual sequence formula input
      -sf, --seqfile=<sequenceFilePath>
                  Path to sequence file
  -V, --version   Print version information and exit.
8. Use program the same way for example:
java -jar seq.jar -sf="C:\sequencefile.ini"
```
### Student number: 9