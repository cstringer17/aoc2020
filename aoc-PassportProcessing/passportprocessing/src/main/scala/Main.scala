import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Main extends App {
  val filename = "D:\\Programming\\aoc\\aoc-PassportProcessing\\passportprocessing\\src\\main\\scala\\input.txt"

  var passports = new ArrayBuffer[mutable.HashMap[String,String]]()

  var passportLine = "";
  var firstrun = true;
    for (line <- Source.fromFile(filename).getLines) {
      if (line == "") {
        var temp = passportLine.split(" ")
        val passport: mutable.HashMap[String, String] = mutable.HashMap()
        for(entry <- temp) {
          var splitEntry = entry.split(":")
          passport += (splitEntry(0) -> splitEntry(1));
        }
        firstrun = true
        passports.addOne(passport)
        //println("New Passport")
        passportLine = ""
      } else {
        //Handle Passport
        if (firstrun) {
          passportLine = passportLine  + line
          firstrun = false
        } else {
        passportLine = passportLine + " " + line
      }
      }
    }

  var goodPassports = 0
  //check passports
  for (pass <- passports){
    println(pass)
    if(pass.contains("byr")
      && pass.contains("iyr")
      && pass.contains("eyr")
      && pass.contains("hgt")
      && pass.contains("hcl")
      && pass.contains("ecl")
      && pass.contains("pid")){
      goodPassports += 1
    }
  }
  println("Valid Passports: " + goodPassports)
}