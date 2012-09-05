package com.esup.faka.module;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.TempFile;
import org.nutz.service.EntityService;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.esup.faka.bean.Stocks;

@At("/Stocks")
@IocBean(fields={"dao"})
public class StocksModule extends EntityService<Stocks>{

    private static final Log log = Logs.get();
    
    
    
//    /**
//	 * 上传考勤汇总
//	 * @param tempFile
//	 * @throws InvalidFormatException
//	 * @throws IOException
//	 * @throws ParseException 
//	 */
//	@At("/upload/tongji")
//	@Ok("json")
//	@AdaptBy(args = {"ioc:upload"})
//	public void upload3(@Param("myfile") TempFile tempFile) throws InvalidFormatException,
//			IOException, ParseException {
//
//		InputStream inp = new FileInputStream(tempFile.getFile());
//		Workbook wb = WorkbookFactory.create(inp);
//		Sheet sheet = wb.getSheetAt(0);
//
//		int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
//		int rowNum = sheet.getLastRowNum();
//				
//		Sql sql = Sqls.create("DELETE BOSS_HR_KAOQIN_TONGJI WHERE KQNY = '"+formatNY(sheet.getRow(1).getCell(27).toString())+"'");
//		List<Tongji> list = new LinkedList<Tongji>();
//		for (int i = 1; i <= rowNum; i++) {
//
//			Tongji o = new Tongji();
//
//			for (int j = 1; j < coloumNum; j++) {
//
//				switch (j) {
//				case 1:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setDept(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 2:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setName(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 3:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setEmNum((sheet.getRow(i).getCell(j).toString()).substring(0, 4));
//					break;
//				case 4:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setRznian(rtnNian(sheet.getRow(i).getCell(j).toString()));
//					break;
//				case 5:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setRzyue(rtnYue(sheet.getRow(i).getCell(j).toString()));
//					break;
//				case 6:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setRzri(rtnRi(sheet.getRow(i).getCell(j).toString()));
//					break;
//				case 7:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setCqts(rtnRi(sheet.getRow(i).getCell(j).toString()));
//					break;
//				case 8:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setSj(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 9:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setBj(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 10:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setKg(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 11:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setBjdz(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 12:
//						o.setSjcq(rtnSJCQ(sheet.getRow(3).getCell(7).toString(), sheet.getRow(i).getCell(8)==null?"0":sheet.getRow(i).getCell(8).toString(), sheet.getRow(i).getCell(9)==null?"0":sheet.getRow(i).getCell(9).toString(), sheet.getRow(i).getCell(10)==null?"0":sheet.getRow(i).getCell(10).toString()));
//					break;
//				case 13:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setCd(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 14:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setZt(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 15:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setWdzw(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 16:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setWdgp(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 17:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setAbts(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 18:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setBbts(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 19:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setCbts(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 20:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setDcfy(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 21:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setPxts(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 22:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setDnbt(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 23:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setSbjn(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 24:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setGjjs(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 25:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setJibie(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 26:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setZxsj(sheet.getRow(i).getCell(j).toString());
//					break;
//				case 27:
//					if(sheet.getRow(i).getCell(j)!=null)
//						o.setKqny(formatNY(sheet.getRow(i).getCell(j).toString()));
//					break;
//				default:
//					break;
//				}
//
//			}
//
//			list.add(o);
//		}
//
//		dao.execute(sql);
//		for (Tongji o : list) {
//			dao.insert(o);
//		}
//	}
    
//	/**
//	 * 读取BOSS周末排班表到考勤系统
//	 * @param month
//	 */
//	@At("/upload/writeworkday")
//	@Ok("json")
//	public void autoWrite3(@Param("month4") String month) {
//
//		List<WorkDay> record = dao.query(WorkDay.class, null);
//
//		final Sql[] sqls = new Sql[record.size()];
//		final Sql[] sql = new Sql[record.size()];
//
//		int i = 0;
//		for (WorkDay temp : record) {
//			//	INSERT INTO USER_OF_RUN VALUES (USERID,NUM_OF_RUN_ID,STARTDATE,ENDDATE,ISNOTOF_RUN,ORDER_RUN) (SELECT USERID,'2011-11-11','2011-11-11',0,0 from USERINFO WHERE BADGENUMBER = '1417')
//
//			if (temp.getWorkDay().substring(0, 7).equalsIgnoreCase(month)) {
//				
//				Sql sql1 = Sqls.create("DELETE user_of_run WHERE CONVERT(varchar, STARTDATE, 120 ) LIKE @STARTDATE AND USERID = (SELECT USERID from userinfo WHERE BADGENUMBER =@BADGENUMBER)");
//				sql1.params().set("STARTDATE", temp.getWorkDay());
//				sql1.params().set("BADGENUMBER", temp.getEmnum());
//				
//				Sql sql2 = Sqls.create("INSERT INTO user_of_run(USERID,NUM_OF_RUN_ID,STARTDATE,ENDDATE,ISNOTOF_RUN,ORDER_RUN) (SELECT USERID,@NUM_OF_RUN_ID,@STARTDATE,@ENDDATE,0,0 from userinfo WHERE BADGENUMBER =@BADGENUMBER)");
//				sql2.params().set("NUM_OF_RUN_ID", temp.getBanciId());
//				sql2.params().set("STARTDATE", temp.getWorkDay());
//				sql2.params().set("ENDDATE", temp.getWorkDay());
//				sql2.params().set("BADGENUMBER", temp.getEmnum());
//				
//				
//				
//				sql[i] = sql1;
//				sqls[i] = sql2;
//				
//				i++;
//			}
//		}
//		
//		dao2.execute(sql);
//		dao2.execute(sqls);
//	}
	
	@At
	public Object list(@Param("page") int page ,@Param("rows") int rows){
		if (rows < 1)
			rows = 10;
		Pager pager = dao().createPager(page, rows);
		List<Stocks> list = dao().query(Stocks.class, null, pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Stocks.class));
			map.put("pager", pager);
		}
		map.put("list", list);
		return map;
	}
	
	@At
	public boolean add(@Param("..") Stocks obj){
		try{
			dao().insert(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean delete(@Param("..") Stocks obj){
		try{
			dao().delete(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
	
	@At
	public boolean update(@Param("..") Stocks obj){
		try{
			dao().update(obj);
			return true;
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return false;
		}
	}
}