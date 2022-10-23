@DslMarker
annotation class ConferenceMarker

@ConferenceMarker
class DslConference {
  var conferenceName = ""
  var talks = ""
  private val keywords = mutableListOf<String>()

  fun keyword(keywordToAdd: String) = keywords.add(keywordToAdd)

  fun talk(talkName: String, talks: TalkInfo.() -> Unit) {
    val talkContext = TalkInfo().apply(talks)
    
    this.talks = "${this.talks}---$talkName - having talk context ${talkContext}"
  }
  
  override fun toString() = """Config:
  - Conference Name: $conferenceName
  - keywords: ${keywords.joinToString()}
  - Talks: $talks
  """.trimMargin()

}

@ConferenceMarker
class TalkInfo {
  var talkName = ""
  
  override fun toString() = "talkName: $talkName"
}

fun build(block: DslConference.() -> Unit) = println(DslConference().apply(block))
