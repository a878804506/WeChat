/*播放列表*/
var song = [
    {
        "title": "往后余生",
        "src": "http://staticfile.erdongchen.top/blog/music/往后余生.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/往后余生.jpg"
    },
    {
        "title": "甜甜的",
        "src": "http://staticfile.erdongchen.top/blog/music/甜甜的.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/甜甜的.jpg"
    },
    {
        "title": "痴心绝对",
        "src": "http://staticfile.erdongchen.top/blog/music/痴心绝对.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/痴心绝对.jpg"
    },
    {
        "title": "告白气球",
        "src": "http://staticfile.erdongchen.top/blog/music/告白气球.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/告白气球.jpg"
    },
    {
        "title": "你是风儿我是沙",
        "src": "http://staticfile.erdongchen.top/blog/music/你是风儿我是沙.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/你是风儿我是沙.jpg"
    },
    {
        "title": "说好的幸福呢",
        "src": "http://staticfile.erdongchen.top/blog/music/说好的幸福呢.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/说好的幸福呢.jpg"
    },
    {
        "title": "做我老婆好不好",
        "src": "http://staticfile.erdongchen.top/blog/music/做我老婆好不好.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/做我老婆好不好.jpg"
    },
    {
        "title": "说好不哭",
        "src": "http://staticfile.erdongchen.top/blog/music/说好不哭.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/说好不哭.jpg"
    },
    {
        "title": "爱在西元前",
        "src": "http://staticfile.erdongchen.top/blog/music/爱在西元前.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/爱在西元前.jpg"
    },
    {
        "title": "彩虹",
        "src": "http://staticfile.erdongchen.top/blog/music/彩虹.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/彩虹.jpg"
    },
    {
        "title": "断了的弦",
        "src": "http://staticfile.erdongchen.top/blog/music/断了的弦.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/断了的弦.jpg"
    },
    {
        "title": "红尘客栈",
        "src": "http://staticfile.erdongchen.top/blog/music/红尘客栈.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/红尘客栈.jpg"
    },
    {
        "title": "花海",
        "src": "http://staticfile.erdongchen.top/blog/music/花海.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/花海.jpg"
    },
    {
        "title": "霍元甲",
        "src": "http://staticfile.erdongchen.top/blog/music/霍元甲.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/霍元甲.jpg"
    },
    {
        "title": "简单爱",
        "src": "http://staticfile.erdongchen.top/blog/music/简单爱.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/简单爱.jpg"
    },
    {
        "title": "跨时代",
        "src": "http://staticfile.erdongchen.top/blog/music/跨时代.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/跨时代.jpg"
    },
    {
        "title": "兰亭序",
        "src": "http://staticfile.erdongchen.top/blog/music/兰亭序.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/兰亭序.jpg"
    },
    {
        "title": "七里香",
        "src": "http://staticfile.erdongchen.top/blog/music/七里香.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/七里香.jpg"
    },
    {
        "title": "世界末日",
        "src": "http://staticfile.erdongchen.top/blog/music/世界末日.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/世界末日.jpg"
    },
    {
        "title": "烟花易冷",
        "src": "http://staticfile.erdongchen.top/blog/music/烟花易冷.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/烟花易冷.jpg"
    },
    {
        "title": "夜曲",
        "src": "http://staticfile.erdongchen.top/blog/music/夜曲.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/夜曲.jpg"
    },
    {
        "title": "最长的电影",
        "src": "http://staticfile.erdongchen.top/blog/music/最长的电影.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/最长的电影.jpg"
    },
    {
        "title": "半岛铁盒",
        "src": "http://staticfile.erdongchen.top/blog/music/半岛铁盒.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/半岛铁盒.jpg"
    },
    {
        "title": "稻香",
        "src": "http://staticfile.erdongchen.top/blog/music/稻香.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/稻香.jpg"
    },
    {
        "title": "发如雪",
        "src": "http://staticfile.erdongchen.top/blog/music/发如雪.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/发如雪.jpg"
    },
    {
        "title": "枫",
        "src": "http://staticfile.erdongchen.top/blog/music/枫.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/枫.jpg"
    },
    {
        "title": "给我一首歌的时间",
        "src": "http://staticfile.erdongchen.top/blog/music/给我一首歌的时间.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/给我一首歌的时间.jpg"
    },
    {
        "title": "搁浅",
        "src": "http://staticfile.erdongchen.top/blog/music/搁浅.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/搁浅.jpg"
    },
    {
        "title": "红尘来去一场梦",
        "src": "http://staticfile.erdongchen.top/blog/music/红尘来去一场梦.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/红尘来去一场梦.jpg"
    },
    {
        "title": "菊花台",
        "src": "http://staticfile.erdongchen.top/blog/music/菊花台.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/菊花台.jpg"
    },
    {
        "title": "明明就",
        "src": "http://staticfile.erdongchen.top/blog/music/明明就.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/明明就.jpg"
    },
    {
        "title": "偏偏喜欢你",
        "src": "http://staticfile.erdongchen.top/blog/music/偏偏喜欢你.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/偏偏喜欢你.jpg"
    },
    {
        "title": "千里之外",
        "src": "http://staticfile.erdongchen.top/blog/music/千里之外.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/千里之外.jpg"
    },
    {
        "title": "青花瓷",
        "src": "http://staticfile.erdongchen.top/blog/music/青花瓷.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/青花瓷.jpg"
    },
    {
        "title": "手放开",
        "src": "http://staticfile.erdongchen.top/blog/music/手放开.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/手放开.jpg"
    },
    {
        "title": "算什么男人",
        "src": "http://staticfile.erdongchen.top/blog/music/算什么男人.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/算什么男人.jpg"
    },
    {
        "title": "what are words",
        "src": "http://staticfile.erdongchen.top/blog/music/what are words.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/what are words.jpg"
    },
    {
        "title": "我不配",
        "src": "http://staticfile.erdongchen.top/blog/music/我不配.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/我不配.jpg"
    },
    {
        "title": "我们不一样",
        "src": "http://staticfile.erdongchen.top/blog/music/我们不一样.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/我们不一样.jpg"
    },
    {
        "title": "一个深爱的女孩",
        "src": "http://staticfile.erdongchen.top/blog/music/一个深爱的女孩.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/一个深爱的女孩.jpg"
    },
    {
        "title": "在人间",
        "src": "http://staticfile.erdongchen.top/blog/music/在人间.mp3",
        "cover": "http://staticfile.erdongchen.top/blog/music/在人间.jpg"
    }
];
/**
 * 音乐播放
 **/
function player(){

    $("#player").css("display","block");

    var audioFn = audioPlay({
        song : song,
        autoPlay : false  //是否立即播放第一首，autoPlay为true且song为空，会alert文本提示并退出
    });
    /* 向歌单中添加新曲目，第二个参数true为新增后立即播放该曲目，false则不播放 */
    /*audioFn.newSong({
        'cover' : 'images/cover4.jpg',
        'src' : 'http://so1.111ttt.com:8282/2016/5/06m/06/199061931237.m4a?tflag=1494769315&pin=a0b26b2dddd976d74724841f6d2641d6&ip=114.233.172.33#.mp3',
        'title' : '极乐净土 - GARNiDELiA'
    },false);*/
    /* 暂停播放 */
    //audioFn.stopAudio();
    /* 开启播放 */
    // audioFn.playAudio();
    /* 选择歌单中索引为3的曲目(索引是从0开始的)，第二个参数true立即播放该曲目，false则不播放 */
    audioFn.selectMenu(0,true);
    /* 查看歌单中的曲目 */
    //console.log(audioFn.song);
    /* 当前播放曲目的对象 */
    //console.log(audioFn.audio);
}
