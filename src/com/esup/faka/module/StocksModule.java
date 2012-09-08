package com.esup.faka.module;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
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

@IocBean(fields = {"dao"})
public class StocksModule extends EntityService<Stocks> {

	private static final Log log = Logs.get();
	private Dao dao;

	/**
	 * 导入实卡到库存
	 * 
	 * @param tempFile
	 * @throws Exception
	 */
	@At("/stocks/import")
	@Ok("json")
	@AdaptBy(args = { "ioc:upload" })
	private void importCard(@Param("cardfile") TempFile tempFile)
			throws Exception {

		InputStream is = new FileInputStream(tempFile.getFile());
		Workbook wb = WorkbookFactory.create(is);
		Sheet sheet = wb.getSheetAt(0);
		int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();
		int rowNum = sheet.getLastRowNum();

		List<Stocks> list = new LinkedList<Stocks>();
		for (int i = 1; i <= rowNum; i++) {

			Stocks o = new Stocks();
			for (int j = 1; j < coloumNum; j++) {

				switch (j) {
				case 1:
					if (sheet.getRow(i).getCell(j) != null)
						o.setCardNo(sheet.getRow(i).getCell(j).toString());
					break;
				case 2:
					if (sheet.getRow(i).getCell(j) != null)
						o.setCardPwd(sheet.getRow(i).getCell(j).toString());
					break;
				case 3:
					if (sheet.getRow(i).getCell(j) != null)
						o.setCardUrl(sheet.getRow(i).getCell(j).toString());
					break;
				case 4:
					if (sheet.getRow(i).getCell(j) != null)
						o.setExpiration(sheet.getRow(i).getCell(j).toString());
					break;
				case 5:
					if (sheet.getRow(i).getCell(j) != null)
						o.setOrderId(Integer.parseInt(rtnNumber(sheet.getRow(i)
								.getCell(j).toString())));
					break;
				default:
					break;
				}
				list.add(o);
			}
		}
		for (Stocks o : list) {
			dao.insert(o);
		}

	}

	private String rtnNumber(String num) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#");
		return df.format(Integer.parseInt(num));
	}


	// /**
	// * 读取BOSS周末排班表到考勤系统
	// * @param month
	// */
	// @At("/upload/writeworkday")
	// @Ok("json")
	// public void autoWrite3(@Param("month4") String month) {
	//
	// List<WorkDay> record = dao.query(WorkDay.class, null);
	//
	// final Sql[] sqls = new Sql[record.size()];
	// final Sql[] sql = new Sql[record.size()];
	//
	// int i = 0;
	// for (WorkDay temp : record) {
	// // INSERT INTO USER_OF_RUN VALUES
	// (USERID,NUM_OF_RUN_ID,STARTDATE,ENDDATE,ISNOTOF_RUN,ORDER_RUN) (SELECT
	// USERID,'2011-11-11','2011-11-11',0,0 from USERINFO WHERE BADGENUMBER =
	// '1417')
	//
	// if (temp.getWorkDay().substring(0, 7).equalsIgnoreCase(month)) {
	//
	// Sql sql1 =
	// Sqls.create("DELETE user_of_run WHERE CONVERT(varchar, STARTDATE, 120 ) LIKE @STARTDATE AND USERID = (SELECT USERID from userinfo WHERE BADGENUMBER =@BADGENUMBER)");
	// sql1.params().set("STARTDATE", temp.getWorkDay());
	// sql1.params().set("BADGENUMBER", temp.getEmnum());
	//
	// Sql sql2 =
	// Sqls.create("INSERT INTO user_of_run(USERID,NUM_OF_RUN_ID,STARTDATE,ENDDATE,ISNOTOF_RUN,ORDER_RUN) (SELECT USERID,@NUM_OF_RUN_ID,@STARTDATE,@ENDDATE,0,0 from userinfo WHERE BADGENUMBER =@BADGENUMBER)");
	// sql2.params().set("NUM_OF_RUN_ID", temp.getBanciId());
	// sql2.params().set("STARTDATE", temp.getWorkDay());
	// sql2.params().set("ENDDATE", temp.getWorkDay());
	// sql2.params().set("BADGENUMBER", temp.getEmnum());
	//
	//
	//
	// sql[i] = sql1;
	// sqls[i] = sql2;
	//
	// i++;
	// }
	// }
	//
	// dao2.execute(sql);
	// dao2.execute(sqls);
	// }

	@At
	public Object list(@Param("page") int page, @Param("rows") int rows) {
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
	public boolean add(@Param("..") Stocks obj) {
		try {
			dao().insert(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}

	@At
	public boolean delete(@Param("..") Stocks obj) {
		try {
			dao().delete(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}

	@At
	public boolean update(@Param("..") Stocks obj) {
		try {
			dao().update(obj);
			return true;
		} catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!", e);
			return false;
		}
	}
}