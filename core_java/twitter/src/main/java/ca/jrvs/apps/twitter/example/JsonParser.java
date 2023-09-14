package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.example.dto.Company;
import ca.jrvs.apps.twitter.model.Data;
import ca.jrvs.apps.twitter.model.Tweet;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

public class JsonParser {

  public static String toJson(Object object, boolean prettyJson, boolean includeNullValues)
      throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();

    if(!includeNullValues) {
      objectMapper.setSerializationInclusion(Include.NON_NULL);
    }
    if(prettyJson) {
      objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    return objectMapper.writeValueAsString(object);
  }

  public static  <T> T toObjectFromJson(String json, Class clazz) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    return (T) objectMapper.readValue(json, clazz);
  }

  public static void main(String[] args) throws IOException {

    //Company company = toObjectFromJson(companyStr, Company.class);
    //System.out.println(toJson(company, true, false));

    Tweet tweet = toObjectFromJson(tweetStr, Data.class);
  }

  public static final String tweetStr = "{\n"
      + "  \"data\": [\n"
      + "    {\n"
      + "      \"text\": \"We believe the best future version of our API will come from building it with YOU. Here?s to another great year with everyone who builds on the Twitter platform. We can?t wait to continue working with you in the new year. https://t.co/yvxdK6aOo2\",\n"
      + "      \"edit_history_tweet_ids\": [\n"
      + "        \"1212092628029698048\"\n"
      + "      ],\n"
      + "      \"lang\": \"en\",\n"
      + "      \"source\": \"Twitter Web App\",\n"
      + "      \"in_reply_to_user_id\": \"2244994945\",\n"
      + "      \"entities\": {\n"
      + "        \"urls\": [\n"
      + "          {\n"
      + "            \"start\": 222,\n"
      + "            \"end\": 245,\n"
      + "            \"url\": \"https://t.co/yvxdK6aOo2\",\n"
      + "            \"expanded_url\": \"https://twitter.com/LovesNandos/status/1211797914437259264/photo/1\",\n"
      + "            \"display_url\": \"pic.twitter.com/yvxdK6aOo2\",\n"
      + "            \"media_key\": \"16_1211797899316740096\"\n"
      + "          }\n"
      + "        ],\n"
      + "        \"annotations\": [\n"
      + "          {\n"
      + "            \"start\": 42,\n"
      + "            \"end\": 44,\n"
      + "            \"probability\": 0.5359,\n"
      + "            \"type\": \"Other\",\n"
      + "            \"normalized_text\": \"API\"\n"
      + "          },\n"
      + "          {\n"
      + "            \"start\": 144,\n"
      + "            \"end\": 150,\n"
      + "            \"probability\": 0.9832,\n"
      + "            \"type\": \"Other\",\n"
      + "            \"normalized_text\": \"Twitter\"\n"
      + "          }\n"
      + "        ]\n"
      + "      },\n"
      + "      \"author_id\": \"2244994945\",\n"
      + "      \"referenced_tweets\": [\n"
      + "        {\n"
      + "          \"type\": \"replied_to\",\n"
      + "          \"id\": \"1212092627178287104\"\n"
      + "        }\n"
      + "      ],\n"
      + "      \"id\": \"1212092628029698048\",\n"
      + "      \"public_metrics\": {\n"
      + "        \"retweet_count\": 7,\n"
      + "        \"reply_count\": 3,\n"
      + "        \"like_count\": 38,\n"
      + "        \"quote_count\": 1\n"
      + "      },\n"
      + "      \"context_annotations\": [\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"29\",\n"
      + "            \"name\": \"Events [Entity Service]\",\n"
      + "            \"description\": \"Real world events. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1186637514896920576\",\n"
      + "            \"name\": \" New Years Eve\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"29\",\n"
      + "            \"name\": \"Events [Entity Service]\",\n"
      + "            \"description\": \"Real world events. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1206982436287963136\",\n"
      + "            \"name\": \"Happy New Year: It?s finally 2020 everywhere!\",\n"
      + "            \"description\": \"Catch fireworks and other celebrations as people across the globe enter the new year.\\nPhoto via @GettyImages \"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"119\",\n"
      + "            \"name\": \"Holiday\",\n"
      + "            \"description\": \"Holidays like Christmas or Halloween\"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1186637514896920576\",\n"
      + "            \"name\": \" New Years Eve\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"119\",\n"
      + "            \"name\": \"Holiday\",\n"
      + "            \"description\": \"Holidays like Christmas or Halloween\"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1206982436287963136\",\n"
      + "            \"name\": \"Happy New Year: It?s finally 2020 everywhere!\",\n"
      + "            \"description\": \"Catch fireworks and other celebrations as people across the globe enter the new year.\\nPhoto via @GettyImages \"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"30\",\n"
      + "            \"name\": \"Entities [Entity Service]\",\n"
      + "            \"description\": \"Entity Service top level domain, every item that is in Entity Service should be in this domain\"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"781974596752842752\",\n"
      + "            \"name\": \"Services\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"47\",\n"
      + "            \"name\": \"Brand\",\n"
      + "            \"description\": \"Brands and Companies\"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"10045225402\",\n"
      + "            \"name\": \"Twitter\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"131\",\n"
      + "            \"name\": \"Unified Twitter Taxonomy\",\n"
      + "            \"description\": \"A taxonomy of user interests. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"10045225402\",\n"
      + "            \"name\": \"Twitter\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"131\",\n"
      + "            \"name\": \"Unified Twitter Taxonomy\",\n"
      + "            \"description\": \"A taxonomy of user interests. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"847868745150119936\",\n"
      + "            \"name\": \"Family & relationships\",\n"
      + "            \"description\": \"Hobbies and interests\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"131\",\n"
      + "            \"name\": \"Unified Twitter Taxonomy\",\n"
      + "            \"description\": \"A taxonomy of user interests. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1196446161223028736\",\n"
      + "            \"name\": \"Social media\"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"29\",\n"
      + "            \"name\": \"Events [Entity Service]\",\n"
      + "            \"description\": \"Real world events. \"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1206982436287963136\",\n"
      + "            \"name\": \"Happy New Year: It?s finally 2020 everywhere!\",\n"
      + "            \"description\": \"Catch fireworks and other celebrations as people across the globe enter the new year.\\nPhoto via @GettyImages \"\n"
      + "          }\n"
      + "        },\n"
      + "        {\n"
      + "          \"domain\": {\n"
      + "            \"id\": \"119\",\n"
      + "            \"name\": \"Holiday\",\n"
      + "            \"description\": \"Holidays like Christmas or Halloween\"\n"
      + "          },\n"
      + "          \"entity\": {\n"
      + "            \"id\": \"1206982436287963136\",\n"
      + "            \"name\": \"Happy New Year: It?s finally 2020 everywhere!\",\n"
      + "            \"description\": \"Catch fireworks and other celebrations as people across the globe enter the new year.\\nPhoto via @GettyImages \"\n"
      + "          }\n"
      + "        }\n"
      + "      ],\n"
      + "      \"created_at\": \"2019-12-31T19:26:16.000Z\",\n"
      + "      \"attachments\": {\n"
      + "        \"media_keys\": [\n"
      + "          \"16_1211797899316740096\"\n"
      + "        ]\n"
      + "      },\n"
      + "      \"possibly_sensitive\": false\n"
      + "    }\n"
      + "  ],\n"
      + "  \"includes\": {\n"
      + "    \"tweets\": [\n"
      + "      {\n"
      + "        \"text\": \"These launches would not be possible without the feedback you provided along the way, so THANK YOU to everyone who has contributed your time and ideas. Have more feedback? Let us know ?? https://t.co/Vxp4UKnuJ9\",\n"
      + "        \"edit_history_tweet_ids\": [\n"
      + "          \"1212092627178287104\"\n"
      + "        ],\n"
      + "        \"lang\": \"en\",\n"
      + "        \"source\": \"Twitter Web App\",\n"
      + "        \"in_reply_to_user_id\": \"2244994945\",\n"
      + "        \"entities\": {\n"
      + "          \"urls\": [\n"
      + "            {\n"
      + "              \"start\": 187,\n"
      + "              \"end\": 210,\n"
      + "              \"url\": \"https://t.co/Vxp4UKnuJ9\",\n"
      + "              \"expanded_url\": \"https://twitterdevfeedback.uservoice.com/forums/921790-twitter-developer-labs\",\n"
      + "              \"display_url\": \"twitterdevfeedback.uservoice.com/forums/921790-?\",\n"
      + "              \"status\": 200,\n"
      + "              \"title\": \"Updates on our feedback channels\",\n"
      + "              \"description\": \"We build our developer platform in the open, with your input and feedback. Over the past year, hearing directly from you and the users of your apps has helped us build developer products that cater to the use case you helped us identify. We want to make this the way we build products, and moving forward, we are consolidating our feedback channels. Meeting you where you are Effective today, we are going to retire our UserVoice feedback channel in favor of more frequent direct engagements with y...\",\n"
      + "              \"unwound_url\": \"https://twittercommunity.com/t/updates-on-our-feedback-channels/169706\"\n"
      + "            }\n"
      + "          ]\n"
      + "        },\n"
      + "        \"author_id\": \"2244994945\",\n"
      + "        \"referenced_tweets\": [\n"
      + "          {\n"
      + "            \"type\": \"replied_to\",\n"
      + "            \"id\": \"1212092626247110657\"\n"
      + "          }\n"
      + "        ],\n"
      + "        \"id\": \"1212092627178287104\",\n"
      + "        \"public_metrics\": {\n"
      + "          \"retweet_count\": 2,\n"
      + "          \"reply_count\": 1,\n"
      + "          \"like_count\": 19,\n"
      + "          \"quote_count\": 0\n"
      + "        },\n"
      + "        \"created_at\": \"2019-12-31T19:26:16.000Z\",\n"
      + "        \"possibly_sensitive\": false\n"
      + "      }\n"
      + "    ]\n"
      + "  }\n"
      + "}";



  public static final String companyStr = "{\n"
      + "   \"symbol\":\"AAPL\",\n"
      + "   \"companyName\":\"Apple Inc.\",\n"
      + "   \"exchange\":\"Nasdaq Global Select\",\n"
      + "   \"description\":\"Apple Inc is designs, manufactures and markets mobile communication and media devices and personal computers, and sells a variety of related software, services, accessories, networking solutions and third-party digital content and applications.\",\n"
      + "   \"CEO\":\"Timothy D. Cook\",\n"
      + "   \"sector\":\"Technology\",\n"
      + "   \"financials\":[\n"
      + "      {\n"
      + "         \"reportDate\":\"2018-12-31\",\n"
      + "         \"grossProfit\":32031000000,\n"
      + "         \"costOfRevenue\":52279000000,\n"
      + "         \"operatingRevenue\":84310000000,\n"
      + "         \"totalRevenue\":84310000000,\n"
      + "         \"operatingIncome\":23346000000,\n"
      + "         \"netIncome\":19965000000\n"
      + "      },\n"
      + "      {\n"
      + "         \"reportDate\":\"2018-09-30\",\n"
      + "         \"grossProfit\":24084000000,\n"
      + "         \"costOfRevenue\":38816000000,\n"
      + "         \"operatingRevenue\":62900000000,\n"
      + "         \"totalRevenue\":62900000000,\n"
      + "         \"operatingIncome\":16118000000,\n"
      + "         \"netIncome\":14125000000\n"
      + "      }\n"
      + "   ],\n"
      + "   \"dividends\":[\n"
      + "      {\n"
      + "         \"exDate\":\"2018-02-09\",\n"
      + "         \"paymentDate\":\"2018-02-15\",\n"
      + "         \"recordDate\":\"2018-02-12\",\n"
      + "         \"declaredDate\":\"2018-02-01\",\n"
      + "         \"amount\":0.63\n"
      + "      },\n"
      + "      {\n"
      + "         \"exDate\":\"2017-11-10\",\n"
      + "         \"paymentDate\":\"2017-11-16\",\n"
      + "         \"recordDate\":\"2017-11-13\",\n"
      + "         \"declaredDate\":\"2017-11-02\",\n"
      + "         \"amount\":0.63\n"
      + "      }\n"
      + "   ]\n"
      + "}";

}