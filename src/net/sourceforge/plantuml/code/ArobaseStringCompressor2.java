/* ========================================================================
 * PlantUML : a free UML diagram generator
 * ========================================================================
 *
 * (C) Copyright 2009-2017, Arnaud Roques
 *
 * Project Info:  http://plantuml.com
 * 
 * If you like this project or if you find it useful, you can support us at:
 * 
 * http://plantuml.com/patreon (only 1$ per month!)
 * http://plantuml.com/paypal
 * 
 * This file is part of PlantUML.
 *
 * PlantUML is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PlantUML distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 *
 * Original Author:  Arnaud Roques
 *
 *
 */
package net.sourceforge.plantuml.code;

import java.io.IOException;

import net.sourceforge.plantuml.StringUtils;

public class ArobaseStringCompressor2 implements StringCompressor {

	public String compress(String data) throws IOException {
		return clean2(data);
	}

	public String decompress(String s) throws IOException {
		return clean2(s);
	}

	private String clean2(String s) {
		s = s.replace("\0", "");
		s = StringUtils.trin(s);
		s = s.replace("\r", "").replaceAll("\n+$", "");
		if (s.startsWith("@start")) {
			return s;
		}
		return "@startuml\n" + s + "\n@enduml";
	}

}