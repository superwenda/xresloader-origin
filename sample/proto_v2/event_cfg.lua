-- this file is generated by xresloader, please don't edit it.

return {
  [1] = {
    count = 5,
    data_ver = "2.8.0.20200609105146",
    description = "Test event_cfg with oneof fields",
    hash_code = "no hash code",
    xres_ver = "2.8.0",
  },
  [2] = "event_cfg",
  event_cfg = {
    {
      item = {
        item_id = 1511,
        item_count = 1512,
        nested_note = "啦啦啦",
      },
      process = 1,
      id = 50001,
      rule = {
        nested_note = "内嵌one of文本",
        rule_id = 511,
        rule_param = 512,
      },
      specify_field = {
        nested_enum_type = 10001,
      },
      test_arr = {
        {
          nested_note = "内嵌one of文本",
          rule_id = 711,
          rule_param = 712,
        },
      },
    },
    {
      process = 2,
      id = 50002,
      rule = {
        rule_id = 521,
        rule_param = 522,
        nested_enum_type = 10001,
      },
      specify_field = {
        nested_enum_type = 10001,
      },
      test_arr = {
        {
          rule_id = 721,
          rule_param = 722,
          nested_enum_type = 10001,
        },
        {
          rule_id = 821,
          rule_param = 822,
          nested_enum_type = 10101,
        },
        {
          nested_note = "数组嵌套one of",
          rule_param = 822,
          rule_id = 921,
        },
      },
      user_exp = 1520,
    },
    {
      process = 3,
      enum_type = 10001,
      id = 50003,
      rule = {
        rule_id = 531,
        rule_param = 532,
        nested_enum_type = 10101,
      },
      specify_field = {
        nested_enum_type = 10101,
      },
    },
    {
      note = "",
      process = 4,
      id = 50004,
      rule = {
        rule_id = 541,
        rule_param = 542,
      },
    },
    {
      process = 5,
      id = 50005,
      rule = {
        rule_id = 551,
        rule_param = 552,
      },
    },
  },
}