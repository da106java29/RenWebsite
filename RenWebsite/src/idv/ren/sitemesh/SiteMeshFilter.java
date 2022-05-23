package idv.ren.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * @author Ren
 * 不使用xml註冊mapping,改用Override的方式註冊對應位置所使用的decorator,
 * 需繼承 ConfigurableSiteMeshFilter, Override "applyCustomConfiguration"該method，
 * 利用 SiteMeshFilterBuilder.addDecoratorPaths(string, string)放入XX路徑，套用XX decorator。
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter{
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPaths("/*", "/WEB-INF/views/sitemesh/sm_head_footer1.jsp");
	}
	
}
