--
-- Name: giftentity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.giftentity (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.giftentity OWNER TO postgres;

--
-- Name: giftentity_aud; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.giftentity_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    name character varying(255)
);


ALTER TABLE public.giftentity_aud OWNER TO postgres;

--
-- Name: giftseq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.giftseq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.giftseq OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: revinfo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


ALTER TABLE public.revinfo OWNER TO postgres;

--
-- Data for Name: giftentity; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.giftentity (id, name) FROM stdin;
\.


--
-- Data for Name: giftentity_aud; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.giftentity_aud (id, rev, revtype, name) FROM stdin;
\.


--
-- Data for Name: revinfo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.revinfo (rev, revtstmp) FROM stdin;
\.


--
-- Name: giftseq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.giftseq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 1, false);


--
-- Name: giftentity_aud giftentity_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftentity_aud
    ADD CONSTRAINT giftentity_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: giftentity giftentity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftentity
    ADD CONSTRAINT giftentity_pkey PRIMARY KEY (id);


--
-- Name: revinfo revinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- Name: giftentity_aud fkni7bi0t9iqefvqyt3ilpwxgyk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.giftentity_aud
    ADD CONSTRAINT fkni7bi0t9iqefvqyt3ilpwxgyk FOREIGN KEY (rev) REFERENCES public.revinfo(rev);

