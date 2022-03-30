package com.titxu.core.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.titxu.core.convert.DictConvert;
import com.titxu.core.pojo.dto.ExcelDictDTO;
import com.titxu.core.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ExcelDictDTOLIstener extends AnalysisEventListener<ExcelDictDTO> {


    private List<ExcelDictDTO> list = new ArrayList<>(1000);


    private DictService service;

    @Override
    public void invoke(ExcelDictDTO data, AnalysisContext context) {
        // log.info("解析到一条数据:{}", data);
        list.add(data);
        if (list.size() >= 1000) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
        saveData();
    }

    protected void saveData() {
        log.info("开始保存数据,有{}条数据", list.size());
        service.saveBatchDict(list);
        log.info("保存数据完成,有{}条数据", list.size());
    }


    public ExcelDictDTOLIstener(DictService service) {
        this.service = service;
    }

}
