package addressbook

import org.joda.time.LocalDate

import scala.io.Source

object AddressBook {
  def readFile: List[AddressEntry] = {
    val entries = for (line <- Source.fromFile("AddressBook").getLines())
    yield {
      val splitLine = line.split(",")
      splitLine.size == 3 match {
        case true => {
          val (forename, surname) = parseName(splitLine(0).trim)
          val gender = parseGender(splitLine(1).trim)
          val dob = parseDoB(splitLine(2).trim)
          new AddressEntry(forename, surname, gender, dob)
        }
        case false => throw new RuntimeException(s"Line format incorrect, ${line}, should contain name, gender and dob")
      }
    }

    entries.toList
  }

  private def parseName(fullName: String): (String, String) = {
    val split = fullName.split(" ")
    (split(0), split(1))
  }

  private def parseGender(gender: String): String = {
    gender.toLowerCase == Gender.MALE match {
      case true => Gender.MALE
      case _ => Gender.FEMALE
    }
  }

  private def parseDoB(dobAsString: String): LocalDate = {
    val split = dobAsString.split("/")
    LocalDate.now.
      withYear(split(2).trim.toInt + 1900).
      withMonthOfYear(split(1).trim.toInt).
      withDayOfMonth(split(0).trim.toInt)
  }

  def entriesByGender(entries: List[AddressEntry], gender: String) = {
    entries.filter(entry => entry.gender == gender)
  }

  def oldest(entries: List[AddressEntry]): AddressEntry = {
    entries.sortBy(entry => entry.dob.toDate).head
  }

  def youngest(entries: List[AddressEntry]): AddressEntry = {
    entries.sortBy(entry => entry.dob.toDate).reverse.head
  }
}
