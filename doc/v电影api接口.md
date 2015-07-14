#V电影API接口
##接口汇总

	* 首页列表
	http://apiv2.vmovier.com/api/post/getPostInCate?cateid=0&p=1
	* Banner轮播图
	http://apiv2.vmovier.com/api/index/getBanner?
	* 系列列表
	http://apiv2.vmovier.com/api/series/getList?p=1
	* 系列详情
	http://apiv2.vmovier.com/api/series/view?seriesid=72
	* 热门列表
	http://apiv2.vmovier.com/api/post/getPostByTab?tab=hot&p=1
	* 幕后列表
	http://apiv2.vmovier.com/api/backstage/getPostByCate?cateid=2&p=1
	* 幕后条目详情
	http://apiv2.vmovier.com/api/post/view?postid=47048
	* 幕后分类列表
	http://apiv2.vmovier.com/api/backstage/getBackstageCate?
	* 星级精选（同热门列表，参数不同）
	http://apiv2.vmovier.com/api/post/getPostByTab?tab=star&p=1
	* 随便看看
	http://apiv2.vmovier.com/api/post/getPostByTab?tab=rand&p=1

##接口明细

###首页列表

*  http://apiv2.vmovier.com/api/post/getPostInCate?cateid=0&p=1

```		
{
    "status": 0,
    "msg": "OK",
    "data": [
        {
            "postid": "46986",
            "title": "【混剪队长】七月全球新片燃爆混剪《July》",
            "is_xpc": 1,
            "is_promote": 0,
            "is_xpc_zp": 1,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-07-01/55935a45d600c_cut.jpeg",
            "rating": "3.8",
            "duration": "129",
            "publish_time": "1435721184",
            "like_num": "1",
            "share_num": "11"
        },
        {
            "postid": "46980",
            "title": "欢快活泼创意短片《五颜六色》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-30/559231b741958_cut.jpeg",
            "rating": "3.6",
            "duration": "159",
            "publish_time": "1435717687",
            "like_num": "1",
            "share_num": "2"
        },
        {
            "postid": "46959",
            "title": "牛人自制国产科幻神作《地矿惊奇》预告片",
            "is_xpc": 1,
            "is_promote": 0,
            "is_xpc_zp": 1,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-26/558d1c2dc4c0e_cut.jpeg",
            "rating": "3.8",
            "duration": "86",
            "publish_time": "1435648080",
            "like_num": "13",
            "share_num": "38"
        },
        {
            "postid": "46974",
            "title": "喜极而泣超感人短片《Proud to love》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-30/5591fca6f2b37_cut.jpeg",
            "rating": "3.6",
            "duration": "144",
            "publish_time": "1435635978",
            "like_num": "29",
            "share_num": "115"
        },
        {
            "postid": "46941",
            "title": "感人催泪求婚短片《说好此生一起走》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-24/558a485af2cac_cut.jpeg",
            "rating": "3.3",
            "duration": "144",
            "publish_time": "1435629990",
            "like_num": "14",
            "share_num": "24"
        },
        {
            "postid": "46956",
            "title": "深山苦行僧侣短片《熊野》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-25/558bb8e50d86d_cut.jpeg",
            "rating": "3.2",
            "duration": "299",
            "publish_time": "1435629937",
            "like_num": "19",
            "share_num": "27"
        },
        {
            "postid": "46966",
            "title": "炫爆城市极限滑雪短片《All.I.Can》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-28/558fb38bc18b9_cut.jpeg",
            "rating": "3.8",
            "duration": "294",
            "publish_time": "1435573003",
            "like_num": "16",
            "share_num": "22"
        },
        {
            "postid": "46969",
            "title": "同志子女与父亲的对话《如果我告诉你我是同性恋》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-29/5590bc70740e7_cut.jpeg",
            "rating": "3.3",
            "duration": "196",
            "publish_time": "1435559730",
            "like_num": "16",
            "share_num": "23"
        },
        {
            "postid": "46879",
            "title": "胖妹子约会尴尬短片《当你约P时，你看中了什么？》",
            "is_xpc": 0,
            "is_promote": 0,
            "is_xpc_zp": 0,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-11/55794b355b317_cut.jpeg",
            "rating": "3.4",
            "duration": "273",
            "publish_time": "1435548803",
            "like_num": "11",
            "share_num": "36"
        },
        {
            "postid": "46885",
            "title": "感人留守儿童微电影《李楠的选择》",
            "is_xpc": 1,
            "is_promote": 0,
            "is_xpc_zp": 1,
            "is_xpc_cp": 0,
            "is_xpc_fx": 0,
            "recent_hot": 0,
            "discussion": 0,
            "image": "http://cs.vmovier.com/Uploads/cover/2015-06-12/557ab5346d1f2_cut.jpeg",
            "rating": "3.1",
            "duration": "655",
            "publish_time": "1435545085",
            "like_num": "16",
            "share_num": "58"
        }
    ]
}
```

### Banner轮播图
* http://apiv2.vmovier.com/api/index/getBanner?

```
{
    "status": 0,
    "msg": "OK",
    "data": [
        {
            "banner_id": "379",
            "title": "",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/07-01/559361e8eb52b.jpg",
            "type": "post",
            "object_id": "46986"
        },
        {
            "banner_id": "378",
            "title": "喜极而泣超感人短片《Proud to love》",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/06-30/5592532356bc1.jpg",
            "type": "post",
            "object_id": "46974"
        },
        {
            "banner_id": "377",
            "title": "虐心结局法国动画短片《CARN》",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/06-29/5590aa6f64b8d.jpg",
            "type": "post",
            "object_id": "46948"
        },
        {
            "banner_id": "375",
            "title": "狱后生活感人短片《走出笼中》",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/06-26/558cec489f143.jpg",
            "type": "post",
            "object_id": "46928"
        },
        {
            "banner_id": "374",
            "title": "",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/06-26/558cfd17c57a6.jpg",
            "type": "post",
            "object_id": "46954"
        },
        {
            "banner_id": "368",
            "title": "【电影自习室】第四十三期",
            "image": "http://apiv2.vmovier.com/Uploads/Vmovier/banner/2015/06-25/558bef28d2ab8.jpg",
            "type": "backstage",
            "object_id": "46958"
        }
    ]
}
```

###文章详情
	* http://www.vmovier.com/46986?qingapp=app_h5
	html
	
	
###系列列表
	* http://apiv2.vmovier.com/api/series/getList?p=1
	
```
{
	"status": 0,
	"msg": "ok",
	"data": [{
		"seriesid": "45",
		"title": "\u7535\u5f71\u81ea\u4e60\u5ba4",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54fec581e98ae.jpg",
		"weekly": "\u6bcf\u5468\u56db\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "49",
		"follower_num": "6276"
	}, {
		"seriesid": "72",
		"title": "\u5c16\u53eb\u5236\u7247\u5382",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-28\/5566c7e023a57.jpg",
		"weekly": "\u6bcf\u5468\u4e94\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "9",
		"follower_num": "248"
	}, {
		"seriesid": "20",
		"title": "\u7535\u5f71\u516c\u55e8\u8bfe",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54fec4db3a280.jpg",
		"weekly": "\u6bcf\u5468\u4e09\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "63",
		"follower_num": "2501"
	}, {
		"seriesid": "40",
		"title": "\u6df7\u526a\u961f\u957f",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54fec553ade6b.jpg",
		"weekly": "\u4e0d\u5b9a\u671f\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "22",
		"follower_num": "1433"
	}, {
		"seriesid": "73",
		"title": "\u6276\u8f6e\u516c\u56ed",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-29\/5567ea6910429.png",
		"weekly": "\u4e0d\u5b9a\u671f\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "2",
		"follower_num": "75"
	}, {
		"seriesid": "53",
		"title": "\u626d\u86cb\u9c9c\u77e5",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54fec50b1bb76.jpg",
		"weekly": "\u6bcf\u5468\u4e94\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "20",
		"follower_num": "486"
	}, {
		"seriesid": "67",
		"title": "\u6bcf\u5468\u661f\u5ea72015",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-04-21\/553618564cebb.png",
		"weekly": "\u4e0d\u5b9a\u671f\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "16",
		"follower_num": "79"
	}, {
		"seriesid": "68",
		"title": " \u6258\u6bd4\u604b\u7231\u5b66",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-04-21\/55361b906e9d3.png",
		"weekly": "\u6bcf\u5468\u4e09\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "18",
		"follower_num": "151"
	}, {
		"seriesid": "62",
		"title": "\u5f02\u60f3",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54feb14d234c3.jpg",
		"weekly": "\u4e0d\u5b9a\u671f\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "10",
		"follower_num": "289"
	}, {
		"seriesid": "64",
		"title": "\u5927\u529b\u91d1\u521a ",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-03-10\/54feb302ed638.jpg",
		"weekly": "\u6bcf\u5468\u4e00\u4e09\u4e94\u66f4\u65b0",
		"isfollow": 0,
		"is_end": 0,
		"update_to": "72",
		"follower_num": "127"
	}]
}
```

###系列详情
	* http://apiv2.vmovier.com/api/series/view?seriesid=72
	
```
{
	"status": 0,
	"msg": "ok",
	"data": {
		"seriesid": "72",
		"title": "\u5c16\u53eb\u5236\u7247\u5382",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-28\/5566c7e023a57.jpg",
		"content": "\u300a\u5c16\u53eb\u5236\u7247\u5382\u300b\u662f\u4e00\u90e8\u6709\u5185\u6db5\u65e0\u8282\u64cd\u3001\u9ad8\u989c\u503c\u5c11\u5e9f\u8bdd\u76843\u5206\u949f\u7f51\u7edc\u77ed\u5267\u3002\u6bcf\u96c6\u4e3b\u9898\u4e0d\u9650\uff0c\u7531\u56fa\u5b9a\u6f14\u5458\u73ed\u5e95\u51fa\u6f14\uff0c\u4ee5\u6076\u641e\u3001\u5410\u69fd\u3001\u8111\u6d1e\u4e3a\u57fa\u8c03\uff0c\u7528\u7535\u5f71\u6c34\u51c6\u7684\u5f71\u50cf\u73a9\u8f6c\u7f51\u7edc\u70ed\u70b9\uff0c\u6253\u9020\u5168\u7f51\u6700\u6709\u8154\u8c03\u3001\u6700\u597d\u7b11\u3001\u6700\u53cd\u8f6c\u7684\u7cfb\u5217\u77ed\u5267\u3002",
		"weekly": "\u6bcf\u5468\u4e94\u66f4\u65b0",
		"count_follow": "248",
		"isfollow": 0,
		"share_link": "http:\/\/www.vmovier.com\/series\/72?_vfrom=VmovierApp",
		"is_end": 0,
		"update_to": 9,
		"tag_name": "\u641e\u7b11\uff0c\u6076\u641e\uff0c\u5267\u60c5\uff0c\u8111\u6d1e\uff0c\u4e0d\u4f4e\u4fd7",
		"post_num_per_seg": 10,
		"posts": [{
			"from_to": "1-9",
			"list": [{
				"number": 9,
				"series_postid": "1321",
				"title": "\u90a3\u4e9b\u5e74\u6211\u4eec\u4e00\u8d77\u76d7\u8fc7\u7684\u5893",
				"addtime": "2015.07.09",
				"type": "",
				"len": "549",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-07-09\/559e18d0c64b7.jpeg"
			}, {
				"number": 8,
				"series_postid": "1312",
				"title": "\u6211\u7684\u91ce\u86ee\u70ae\u53cb",
				"addtime": "2015.07.02",
				"type": "",
				"len": "548",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-07-02\/55950f126dc7f.jpeg"
			}, {
				"number": 7,
				"series_postid": "1291",
				"title": "\u5f53\u5b85\u7537\u604b\u4e0a\u4eff\u771f\u673a\u5668\u7f8e\u5973",
				"addtime": "2015.06.25",
				"type": "",
				"len": "357",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-06-25\/558ba940c68e4.jpeg"
			}, {
				"number": 6,
				"series_postid": "1280",
				"title": "\u6709\u4e2a\u86c7\u7cbe\u75c5\u8001\u7238\u600e\u4e48\u529e",
				"addtime": "2015.06.18",
				"type": "",
				"len": "280",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-06-18\/55826c7c304a7.jpeg"
			}, {
				"number": 5,
				"series_postid": "1270",
				"title": "\u4e0d\u901f\u4e4b\u5ba2",
				"addtime": "2015.06.11",
				"type": "",
				"len": "345",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-06-11\/55795be3c2543.jpg"
			}, {
				"number": 4,
				"series_postid": "1256",
				"title": "\u51b3\u6218\u9ad8\u8003\uff01\u5b66\u6e23\u6df1\u85cf\u529f\u4e0e\u540d",
				"addtime": "2015.06.04",
				"type": "",
				"len": "232",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-06-04\/55700d7ac8112.jpeg"
			}, {
				"number": 3,
				"series_postid": "1238",
				"title": "\u590d\u4ec7\u8005\u8054\u76df\u4e4b\u563b\u7f8a\u7f8a\u667a\u53d6\u72fc\u56fe\u817e",
				"addtime": "2015.05.28",
				"type": "",
				"len": "234",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-28\/5566c8cbdb0c8.jpeg"
			}, {
				"number": 2,
				"series_postid": "1237",
				"title": "\u767d\u96ea\u516c\u4e3b\uff1a\u542c\u8bf4\u6bcd\u540e\u4e70\u4e86\u4e2a\u8868",
				"addtime": "2015.05.28",
				"type": "",
				"len": "305",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-28\/5566c89866e79.jpeg"
			}, {
				"number": 1,
				"series_postid": "1236",
				"title": "\u4e94\u5341\u5ea6\u7070\u4e4b\u60ca\u58f0\u5c16\u53eb",
				"addtime": "2015.05.28",
				"type": "",
				"len": "207",
				"thumbnail": "http:\/\/cs.vmovier.com\/Uploads\/Series\/2015-05-28\/5566c87137f4c.jpeg"
			}]
		}]
	}
}
```

###热门列表
	* http://apiv2.vmovier.com/api/post/getPostByTab?tab=hot&p=1
	
```
{
	"status": 0,
	"msg": "OK",
	"data": [{
		"postid": "47007",
		"title": "\u9707\u64bc\u6cbb\u6108\u77ed\u7247\u300a\u4f60\u770b\u8d77\u6765\u4ee4\u4eba\u6076\u5fc3\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-05\/55993d3739193_cut.jpeg",
		"rating": "3.7",
		"duration": "190",
		"publish_time": "1436146919",
		"like_num": "156",
		"share_num": "674"
	}, {
		"postid": "47024",
		"title": "\u53d1\u4eba\u6df1\u7701\u52b1\u5fd7\u77ed\u7247\u300a\u5982\u679c\u94b1\u4e0d\u662f\u95ee\u9898\uff0c\u4f60\u6700\u60f3\u5e72\u4ec0\u4e48\uff1f\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-07\/559b685e2ffcb_cut.jpeg",
		"rating": "3.8",
		"duration": "189",
		"publish_time": "1436513778",
		"like_num": "100",
		"share_num": "357"
	}, {
		"postid": "46974",
		"title": "\u559c\u6781\u800c\u6ce3\u8d85\u611f\u4eba\u77ed\u7247\u300aProud to love\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-06-30\/5591fca6f2b37_cut.jpeg",
		"rating": "3.7",
		"duration": "144",
		"publish_time": "1435635978",
		"like_num": "89",
		"share_num": "342"
	}, {
		"postid": "46960",
		"title": "\u9707\u64bc\u795e\u5947\u4e07\u7269\u751f\u957f\u5ef6\u65f6\u6444\u5f71\u300a\u5947\u8ff9\u68ee\u6797\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-06-26\/558cf8f223cd7_cut.jpeg",
		"rating": "4.1",
		"duration": "211",
		"publish_time": "1435902105",
		"like_num": "130",
		"share_num": "319"
	}, {
		"postid": "47001",
		"title": "\u5c4c\u4e1d\u7ea6\u70ae\u8f9b\u9178\u53f2\u300a\u5c16\u53eb\u5236\u7247\u5382\u300bS01E08",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-02\/5595140a13849_cut.jpeg",
		"rating": "3.3",
		"duration": "548",
		"publish_time": "1435837908",
		"like_num": "28",
		"share_num": "180"
	}, {
		"postid": "46977",
		"title": "\u53cd\u601d\u73b0\u5b9e\u611f\u4eba\u77ed\u7247\u300a\u73cd\u60dc\u62e5\u6709\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-06-30\/55920f96b6556_cut.jpeg",
		"rating": "4.1",
		"duration": "539",
		"publish_time": "1436079127",
		"like_num": "78",
		"share_num": "222"
	}, {
		"postid": "46986",
		"title": "\u3010\u6df7\u526a\u961f\u957f\u3011\u4e03\u6708\u5168\u7403\u65b0\u7247\u71c3\u7206\u6df7\u526a\u300aJuly\u300b",
		"is_xpc": 1,
		"is_promote": 0,
		"is_xpc_zp": 1,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-01\/55935a45d600c_cut.jpeg",
		"rating": "3.8",
		"duration": "129",
		"publish_time": "1435721184",
		"like_num": "43",
		"share_num": "196"
	}, {
		"postid": "47015",
		"title": "\u9177\u70ab\u526a\u8f91\u52b1\u5fd7\u7535\u5f71\u8bd7\u77ed\u7247\u300a\u8fc7\u53bb \u00b7 \u73b0\u5728 \u00b7 \u672a\u6765\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-06\/559a39ba89fd2_cut.jpeg",
		"rating": "4.1",
		"duration": "234",
		"publish_time": "1436234274",
		"like_num": "86",
		"share_num": "170"
	}, {
		"postid": "47027",
		"title": "\u8d85\u60ca\u609a\u53cd\u8f6c\u521b\u610f\u5e7f\u544a\u77ed\u7247\u300a\u9a71\u9b54\u4eba\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-07\/559b87db19921_cut.jpeg",
		"rating": "3.7",
		"duration": "217",
		"publish_time": "1436414783",
		"like_num": "58",
		"share_num": "139"
	}, {
		"postid": "47029",
		"title": "\u8d85\u6696\u8d85\u6cbb\u6108\u97e9\u56fd\u52a8\u753b\u300a\u7231\u662f\u4ec0\u4e48\u300b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"recent_hot": 0,
		"discussion": 0,
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-07\/559b926bab98b_cut.jpeg",
		"rating": "3.6",
		"duration": "84",
		"publish_time": "1436320403",
		"like_num": "65",
		"share_num": "197"
	}]
}
```

###幕后列表
	* http://apiv2.vmovier.com/api/backstage/getPostByCate?cateid=2&p=1
	
```
{
	"status": 0,
	"msg": "OK",
	"data": [{
		"cateid": "4",
		"postid": "47074",
		"title": "\u8fd9\u4e00\u5b9a\u662f\u4e16\u754c\u4e0a\u6700\u75af\u72c2\u7684\u7535\u5f71\u5e55\u540e",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47074?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-13\/55a3a5fdcb625_cut.jpeg",
		"rating": "0",
		"duration": "183",
		"publish_time": "1436789706",
		"like_num": "2",
		"share_num": "6",
		"video_link": "http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgwOA==.html,http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgwMA==.html,http:\/\/v.youku.com\/v_show\/id_XMTI4NDAxMTgxMg==.html"
	}, {
		"cateid": "26",
		"postid": "47064",
		"title": "\u3010New Talk\u7b2c11\u671f\u3011\u6768\u6d0b\uff1a\u5728\u5f71\u9662\u770b\u7535\u5f71\uff0c\u4f60\u7684\u4f53\u9a8c\u548c\u601d\u8003\u5b8c\u5168\u4e0d\u4e00\u6837",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47064?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-13\/55a31d24546b4_cut.jpeg",
		"rating": "0",
		"duration": "1",
		"publish_time": "1436753612",
		"like_num": "0",
		"share_num": "0",
		"video_link": ""
	}, {
		"cateid": "30",
		"postid": "47048",
		"title": "\u3010\u7535\u5f71\u81ea\u4e60\u5ba4\u3011\u8d70\u8fdb\u7247\u573a-\u8c03\u8272(\u4e0b)",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-09\/559e363883567_cut.jpeg",
		"rating": "0",
		"duration": "754",
		"publish_time": "1436447173",
		"like_num": "26",
		"share_num": "88",
		"video_link": "http:\/\/v.youku.com\/v_show\/id_XMTI4MTAyMTM2MA==.html"
	}, {
		"cateid": "26",
		"postid": "47039",
		"title": "\u7f16\u5267\u5927\u5e08\u90fd\u7231\u73a9\u8fd9\u4e2a\u5c0f\u6e38\u620f",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47039?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-08\/559d05c800b9e_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1436356123",
		"like_num": "6",
		"share_num": "11",
		"video_link": ""
	}, {
		"cateid": "26",
		"postid": "47016",
		"title": "\u90ed\u656c\u660e\uff1a\u5173\u4e8e\u300a\u5c0f\u65f6\u4ee3\u300b\u7684\u6700\u540e\u4e00\u7bc7\u6587\u7ae0\uff0c\u8fdf\u6765\u7684\u544a\u522b\u4ecd\u662f\u544a\u522b",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47016?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-06\/559a4650a8463_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1436173940",
		"like_num": "0",
		"share_num": "3",
		"video_link": ""
	}, {
		"cateid": "26",
		"postid": "47012",
		"title": "\u4e16\u754c\u540d\u5bfc\u5982\u679c\u53bb\u76d6\u623f\u5b50\uff0c\u4f60\u60f3\u4f4f\u8c01\u7684\uff1f",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47012?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-06\/559a01b5b9c71_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1436171417",
		"like_num": "0",
		"share_num": "5",
		"video_link": ""
	}, {
		"cateid": "26",
		"postid": "47009",
		"title": "\u3010New Talk\u7b2c10\u671f\u5168\u8bb0\u5f55\u3011 \u738b\u9aa5\u4f1f\uff1a\u7f16\u5267\u5199\u51f6\u6740\u6848\uff0c\u4e0d\u7528\u81ea\u5df1\u53bb\u6740\u4e2a\u4eba",
		"is_xpc": 1,
		"is_promote": 0,
		"is_xpc_zp": 1,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47009?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-06\/559a1cc150077_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1436167018",
		"like_num": "2",
		"share_num": "3",
		"video_link": ""
	}, {
		"cateid": "26",
		"postid": "47002",
		"title": "\u53d9\u4e8b\u8c0b\u7565\uff1a\u597d\u83b1\u575e\u5f71\u7247\u5438\u5f15\u89c2\u4f17\u7684\u6740\u62db",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/47002?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-02\/5595237f6851a_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1435884500",
		"like_num": "7",
		"share_num": "9",
		"video_link": ""
	}, {
		"cateid": "26",
		"postid": "46999",
		"title": "\u3010\u7535\u5f71\u81ea\u4e60\u5ba4\u3011\u8d70\u8fdb\u7247\u573a-\u8c03\u8272\uff08\u4e0a\uff09",
		"is_xpc": 0,
		"is_promote": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/46999?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-02\/5595009c5f9e9_cut.jpeg",
		"rating": "0",
		"duration": "751",
		"publish_time": "1435829533",
		"like_num": "59",
		"share_num": "161",
		"video_link": "http:\/\/v.youku.com\/v_show\/id_XMTI3NTYxMTAwMA==.html"
	}, {
		"cateid": "4",
		"postid": "46975",
		"title": "\u5982\u4f55\u5236\u9020\u7535\u5f71\u611f \u2014\u2014\u6444\u5f71\u7bc7\u4e4b\u6784\u56fe",
		"is_xpc": 1,
		"is_promote": 0,
		"is_xpc_zp": 1,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_collect": 0,
		"share_link": "http:\/\/www.vmovier.com\/46975?_vfrom=VmovierApp",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-06-30\/559207f19dbfb_cut.jpeg",
		"rating": "0",
		"duration": "0",
		"publish_time": "1435633963",
		"like_num": "44",
		"share_num": "49",
		"video_link": ""
	}]
}
```
###幕后条目详情
	* http://apiv2.vmovier.com/api/post/view?postid=47048
	
```
{
	"status": 0,
	"msg": "OK",
	"data": {
		"postid": "47048",
		"title": "\u3010\u7535\u5f71\u81ea\u4e60\u5ba4\u3011\u8d70\u8fdb\u7247\u573a-\u8c03\u8272(\u4e0b)",
		"is_collect": 0,
		"content": "(\u6682\u65e0\u4ecb\u7ecd)",
		"image": "http:\/\/cs.vmovier.com\/Uploads\/cover\/2015-07-09\/559e363883567_cut.jpeg",
		"duration": "754",
		"rating": "0",
		"publish_time": "1436447173",
		"cate": ["\u540e\u671f", "\u7535\u5f71\u81ea\u4e60\u5ba4"],
		"video_link": "http:\/\/v.youku.com\/v_show\/id_XMTI4MTAyMTM2MA==.html",
		"vmovier_url": "http:\/\/www.vmovier.com\/47048?app_inner=1&_vfrom=android_app_to_web",
		"share_link": {
			"sweibo": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
			"tweibo": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
			"renren": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
			"weixin": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
			"qzone": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp",
			"qq": "http:\/\/www.vmovier.com\/47048?_vfrom=VmovierApp"
		},
		"download_link": {
			"mp4": ["http:\/\/k.youku.com\/player\/getFlvPath\/sid\/443686670256512f9ddeb_00\/st\/mp4\/fileid\/0300080200559E79C15D3705C062B813AA01C2-056B-3709-A777-37427F06F063?K=d4fb855cb5721471282aa1b3&hd=1&myp=0&ts=406&ypp=0&ctype=12&ev=1&token=6146&oip=2032717543&ep=diaXHEGLUMkA5ybZjT8bMSW2ICJdXP4J9h%2BFidJgALshTeHKnjeixpjETfhCE4oZdCB0GOry2qHnazMWYfBGrxoQ3EmoMPqR%2Bffk5a5UwJIHEBkwBM3Rt1SYQjT3", "http:\/\/k.youku.com\/player\/getFlvPath\/sid\/443686670256512f9ddeb_00\/st\/mp4\/fileid\/0300080201559E79C15D3705C062B813AA01C2-056B-3709-A777-37427F06F063?K=e6287ee13a28e3ed261e7380&hd=1&myp=0&ts=348&ypp=0&ctype=12&ev=1&token=6146&oip=2032717543&ep=diaXHEGLUMkA5ybZjT8bMSW2ICJdXP4J9h%2BFidJgALohTeHKnjeixpjETfhCE4oZdCB0GOry2qHnazMWYfBGrxoQ3EmoMPqR%2Bffk5a5UwJIHEBkwBM3Rt1SYQjT3"],
			"flv": []
		},
		"play_link": {
			"mp4": ["http:\/\/k.youku.com\/player\/getFlvPath\/sid\/443686670256512f9ddeb_00\/st\/mp4\/fileid\/0300080200559E79C15D3705C062B813AA01C2-056B-3709-A777-37427F06F063?K=d4fb855cb5721471282aa1b3&hd=1&myp=0&ts=406&ypp=0&ctype=12&ev=1&token=6146&oip=2032717543&ep=diaXHEGLUMkA5ybZjT8bMSW2ICJdXP4J9h%2BFidJgALshTeHKnjeixpjETfhCE4oZdCB0GOry2qHnazMWYfBGrxoQ3EmoMPqR%2Bffk5a5UwJIHEBkwBM3Rt1SYQjT3", "http:\/\/k.youku.com\/player\/getFlvPath\/sid\/443686670256512f9ddeb_00\/st\/mp4\/fileid\/0300080201559E79C15D3705C062B813AA01C2-056B-3709-A777-37427F06F063?K=e6287ee13a28e3ed261e7380&hd=1&myp=0&ts=348&ypp=0&ctype=12&ev=1&token=6146&oip=2032717543&ep=diaXHEGLUMkA5ybZjT8bMSW2ICJdXP4J9h%2BFidJgALohTeHKnjeixpjETfhCE4oZdCB0GOry2qHnazMWYfBGrxoQ3EmoMPqR%2Bffk5a5UwJIHEBkwBM3Rt1SYQjT3"],
			"flv": [],
			"m3u8": "http:\/\/pl.youku.com\/playlist\/m3u8?vid=320255340&type=mp4&ep=cSaXHEGLUMkA5yHYij8bbym3cXAGXP0I9h2AhNFmANQlS%2B69&token=1362&ctype=12&ev=1&oip=2032717543&sid=34368667022721285e579"
		},
		"is_xpc": 0,
		"is_xpc_zp": 0,
		"is_xpc_cp": 0,
		"is_xpc_fx": 0,
		"is_promote": 0,
		"recent_hot": 0,
		"discussion": 0,
		"editor": {
			"username": "\u6012\u8c46\u6e23"
		}
	}
}
```
###幕后分类列表
	* http://apiv2.vmovier.com/api/backstage/getBackstageCate?
	
```
{
	"status": 0,
	"msg": "OK",
	"data": [{
		"cateid": "2",
		"catename": "\u5168\u90e8"
	}, {
		"cateid": "47",
		"catename": "\u7535\u5f71\u81ea\u4e60\u5ba4"
	}, {
		"cateid": "53",
		"catename": "\u7535\u5f71\u4f1a\u5ba2\u5385"
	}, {
		"cateid": "4",
		"catename": "\u62cd\u6444"
	}, {
		"cateid": "26",
		"catename": "\u7efc\u8ff0"
	}, {
		"cateid": "30",
		"catename": "\u540e\u671f"
	}, {
		"cateid": "31",
		"catename": "\u5668\u6750"
	}]
}
```