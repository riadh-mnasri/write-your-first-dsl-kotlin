object organize {
    infix fun talk(block: Talk.() -> Unit) = print(Talk().apply(block))
}

class Talk {
    var talkTitle = ""
    var startTime = IntRange.EMPTY
    var endTime = IntRange.EMPTY
    var attending = ""
    var presenting = ""
    val assign = this
    val starts = Starts()
    val ends = Ends()
    val speakers = Speakers()
    val participants = Attendees()

    infix fun name(name: String) {
        talkTitle = name
    }

    inner class Starts {
        infix fun at(time: IntRange) {
            startTime = time
        }
    }

    inner class Ends {
        infix fun at(time: IntRange) {
            endTime = time
        }
    }

    inner class Attendees {
        infix fun include(name: String): Attendees = apply {
            attending = name
        }

        infix fun and(name: String): Attendees = apply {
            attending = "$attending, $name"
        }
    }

    inner class Speakers {
        infix fun include(name: String): Speakers = apply {
            presenting = name
        }

        infix fun and(name: String): Speakers = apply {
            presenting = "$presenting, $name"
        }
    }

    override fun toString() = """Meeting: $talkTitle
  |Starts at ${startTime.start}:${startTime.endInclusive}
  |Ends at ${endTime.start}:${endTime.endInclusive}
  |Speakers: ${presenting}
  |Participants: ${attending}
  |
  """.trimMargin()
}

/*fun main() {
    organize talk {
        assign name "Write your first DSL"
        starts at 16..30
        ends at 17..15
        speakers include "Riadh" and "Romain"
        participants include "Dimitri" and "Cyril" and "Mohamed" and "Sonia" and "Isabelle"
    }
}*/
