package com.zhy.wisdom.demo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;

import java.util.HashMap;

public class Temp {

    @Test
    public void test() {
        HashMap<String, domin> map = new HashMap<>();
        map.put("异维A酸软胶囊",new domin("口服药物","显著抑制皮脂腺脂质分泌；调节毛囊皮脂腺导管异常角化；改善毛囊厌氧环境从而减少痤疮丙酸杆菌繁殖；抗炎和预防瘢痕形成","口服，初始剂量为 0.25～0.5 mg/kg·d，之后根据患者耐受性和疗效逐渐调整剂量；重度结节囊肿性痤疮可逐渐增加至 0.5～1.0 mg/kg·d","4574091,100012549076"));
        map.put("盐酸米诺环素胶囊",new domin("口服药物","抗痤疮丙酸杆菌、抗炎","口服，100～200 mg/d","4393772,4158918"));
        map.put("达英35",new domin("口服药物","通过抑制雄激素前体生成或作用于皮肤内雄激素代谢酶和雄激素受体，进而减少或拮抗雄激素活性作用而减少皮脂腺分泌脂质和改善痤疮","口服，月经周期的第 1 天开始服药，每日 1 片，连服 21 天，停药 7 天后继续服药","3470630"));
        map.put("阿达帕林凝胶",new domin("外用药物","改善毛囊皮脂腺导管角化、溶解微粉刺和粉刺、抗炎、预防和改善痤疮炎症后色素沉着和痤疮瘢痕等作用；增加皮肤渗透性，在联合治疗中增加外用抗菌及抗炎药物的疗效","外用，每晚睡前1次","4885253"));
        map.put("过氧化苯甲酰凝胶",new domin("外用药物","缓慢释放出新生态氧和苯甲酸，杀灭痤疮丙酸杆菌、抗炎及轻度溶解粉刺作用","外用，每日1-2次","46245167030,10593643471"));
        map.put("夫西地酸乳膏",new domin("外用药物","抗痤疮丙酸杆菌，抗炎作用","外用，每日早晚各1次","4399635,100011430120"));
        map.put("维A酸乳膏",new domin("外用药物","改善毛囊皮脂腺导管角化、溶解微粉刺和粉刺、抗炎、预防和改善痤疮炎症后色素沉着和痤疮瘢痕等作用；增加皮肤渗透性，在联合治疗中增加外用抗菌及抗炎药物的疗效","外用，每晚睡前1次","100011239280,5634100"));
        System.out.println(JSON.toJSONString(map));
    }

    @Data
    class domin{
        private String type;
        private String effect;
        private String usage;
        private String skuIds;

        public domin(String type, String effect, String usage, String skuIds) {
            this.type = type;
            this.effect = effect;
            this.usage = usage;
            this.skuIds = skuIds;
        }
    }
}
