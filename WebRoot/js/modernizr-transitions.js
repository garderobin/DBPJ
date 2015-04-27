/* Modernizr custom build of 1.7: csstransitions */
window.Modernizr = function(a, b, c) {
    function G() {}
    function F(a, b) {
        var c = a.charAt(0).toUpperCase() + a.substr(1), d = (a + " " + p.join(c + " ") + c).split(" ");
        return !!E(d, b)
    }
    function E(a, b) {
        for (var d in a)
            if (k[a[d]] !== c && (!b || b(a[d], j)))
                return !0
    }
    function D(a, b) {
        return ("" + a).indexOf(b)!==-1
    }
    function C(a, b) {
        return typeof a === b
    }
    function B(a, b) {
        return A(o.join(a + ";") + (b || ""))
    }
    function A(a) {
        k.cssText = a
    }
    var d = "1.7", e = {}, f=!0, g = b.documentElement, h = b.head || b.getElementsByTagName("head")[0], i = "modernizr", j = b.createElement(i), k = j.style, l = b.createElement("input"), m = ":)", n = Object.prototype.toString, o = " -webkit- -moz- -o- -ms- -khtml- ".split(" "), p = "Webkit Moz O ms Khtml".split(" "), q = {
        svg: "http://www.w3.org/2000/svg"
    }, r = {}, s = {}, t = {}, u = [], v, w = function(a) {
        var c = b.createElement("style"), d = b.createElement("div"), e;
        c.textContent = a + "{#modernizr{height:3px}}", h.appendChild(c), d.id = "modernizr", g.appendChild(d), e = d.offsetHeight === 3, c.parentNode.removeChild(c), d.parentNode.removeChild(d);
        return !!e
    }, x = function() {
        function d(d, e) {
            e = e || b.createElement(a[d] || "div");
            var f = (d = "on" + d)in e;
            f || (e.setAttribute || (e = b.createElement("div")), e.setAttribute && e.removeAttribute && (e.setAttribute(d, ""), f = C(e[d], "function"), C(e[d], c) || (e[d] = c), e.removeAttribute(d))), e = null;
            return f
        }
        var a = {
            select: "input",
            change: "input",
            submit: "form",
            reset: "form",
            error: "img",
            load: "img",
            abort: "img"
        };
        return d
    }(), y = ({}).hasOwnProperty, z;
    C(y, c) || C(y.call, c) ? z = function(a, b) {
        return b in a && C(a.constructor.prototype[b], c)
    } : z = function(a, b) {
        return y.call(a, b)
    }, r.csstransitions = function() {
        return F("transitionProperty")
    };
    for (var H in r)
        z(r, H) && (v = H.toLowerCase(), e[v] = r[H](), u.push((e[v] ? "" : "no-") + v));
    e.input || G(), e.crosswindowmessaging = e.postmessage, e.historymanagement = e.history, e.addTest = function(a, b) {
        a = a.toLowerCase();
        if (!e[a]) {
            b=!!b(), g.className += " " + (b ? "" : "no-") + a, e[a] = b;
            return e
        }
    }, A(""), j = l = null, e._enableHTML5 = f, e._version = d, g.className = g.className.replace(/\bno-js\b/, "") + " js " + u.join(" ");
    return e
}(this, this.document)

